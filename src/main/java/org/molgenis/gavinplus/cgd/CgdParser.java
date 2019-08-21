package org.molgenis.gavinplus.cgd;

import static com.google.common.collect.ImmutableList.toImmutableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.molgenis.gavinplus.cgd.CgdRecord.Builder;
import org.molgenis.gavinplus.cgd.model.AgeGroup;
import org.molgenis.gavinplus.cgd.model.Inheritance;
import org.molgenis.gavinplus.cgd.model.InterventionCategory;
import org.molgenis.gavinplus.cgd.model.ManifestationCategory;

public class CgdParser implements AutoCloseable {

  private static final String HEADER = "#GENE\tHGNC ID\tENTREZ GENE ID\tCONDITION\tINHERITANCE\tAGE GROUP\tALLELIC CONDITIONS\tMANIFESTATION CATEGORIES\tINTERVENTION CATEGORIES\tCOMMENTS\tINTERVENTION/RATIONALE\tREFERENCES";

  private final BufferedReader bufferedReader;
  private final AtomicInteger lineNumber = new AtomicInteger(1);

  CgdParser(Reader reader) throws IOException {
    this.bufferedReader =
        reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    parseHeader();
  }

  public Stream<CgdRecord> stream() {
    return bufferedReader.lines().map(this::map);
  }

  @Override
  public void close() throws Exception {
    bufferedReader.close();
  }

  private void parseHeader() throws IOException {
    String headerLine = bufferedReader.readLine();
    if (headerLine == null) {
      throw new IOException("Missing header line");
    }
    if (!headerLine.equals(HEADER)) {
      throw new IOException(
          "Invalid header line:\nexpected: " + HEADER + "\n  actual: " + headerLine);
    }
  }

  @SuppressWarnings("UnstableApiUsage")
  private CgdRecord map(String line) {
    int currentLineNumber = lineNumber.incrementAndGet();

    String[] tokens = line.split("\t", -1);
    Builder builder = CgdRecord.builder();
    builder.setGene(tokens[0].trim());
    builder.setHgncId(Integer.parseInt(tokens[1].trim()));
    builder.setEntrezGeneId(Integer.parseInt(tokens[2].trim()));
    builder.setCondition(tokens[3] != null ? tokens[3].trim() : null);
    builder
        .setInheritance(
            Arrays.stream(tokens[4].split("/")).map(String::trim).map(Inheritance::get)
                .filter(inheritance -> {
                  if (inheritance == null) {
                    System.err
                        .println("line:" + currentLineNumber + " gene: " + tokens[0]
                            + " error parsing INHERITANCE: "
                            + tokens[4]);
                  }
                  return inheritance != null;
                })
                .collect(
                    toImmutableList()));
    builder.setAgeGroup(
        Arrays.stream(tokens[5].split(";")).map(String::trim)
            .filter(token -> !token.equals("N/A"))
            .map(AgeGroup::get).filter(ageGroup -> {
              if (ageGroup == null) {
                System.err
                    .println("line:" + currentLineNumber + " gene: " + tokens[0]
                        + " error parsing AGE GROUP: " + tokens[5]);
              }
              return ageGroup != null;
            }
        ).collect(
            toImmutableList()));
    builder.setAllelicConditions(tokens[6].trim());
    builder.setManifestationCategories(
        Arrays.stream(tokens[7].split(";")).map(String::trim)
            .filter(token -> !token.equals("N/A")).map(ManifestationCategory::get)
            .filter(Objects::nonNull)
            .collect(
                toImmutableList()));
    builder.setInterventionCategories(
        Arrays.stream(tokens[8].split(";")).map(String::trim)
            .filter(token -> !token.equals("N/A")).map(InterventionCategory::get)
            .filter(interventionCategory -> {
                  if (interventionCategory == null) {
                    System.err
                        .println(
                            "line:" + currentLineNumber + " gene: " + tokens[0]
                                + " error parsing INTERVENTION CATEGORIES: "
                                + tokens[8]);
                  }
                  return interventionCategory != null;
                }
            )
            .collect(
                toImmutableList()));
    builder.setComments(tokens[9] != null ? tokens[9].trim() : null);
    builder.setInterventionRationale(tokens[10] != null ? tokens[10].trim() : null);
    builder.setReferences(
        Arrays.stream(tokens[11].split(";")).map(String::trim)
            .flatMap(token -> Arrays.stream(token.split(" ")))
            .map(subtoken -> {
              try {
                return Integer.parseInt(subtoken);
              } catch (NumberFormatException e) {
                System.err.println(
                    "line:" + currentLineNumber + " gene: " + tokens[0]
                        + " error parsing REFERENCES: " + tokens[11]
                        + " (expected '" + subtoken + "' to be an integer)");
                return null;
              }
            }).filter(Objects::nonNull).collect(
            toImmutableList()));
    return builder.build();
  }
}
