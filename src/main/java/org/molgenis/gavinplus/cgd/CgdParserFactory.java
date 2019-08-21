package org.molgenis.gavinplus.cgd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class CgdParserFactory {

  private CgdParserFactory() {
  }

  public static CgdParser create(File cgdFile) throws IOException {
    InputStream inputStream = new FileInputStream(cgdFile);
    if (cgdFile.getName().endsWith(".gz")) {
      inputStream = new GZIPInputStream(inputStream);
    }
    return new CgdParser(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
  }
}
