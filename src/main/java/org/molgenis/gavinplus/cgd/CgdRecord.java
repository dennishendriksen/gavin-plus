package org.molgenis.gavinplus.cgd;

import com.google.auto.value.AutoValue;
import java.util.List;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import org.molgenis.gavinplus.cgd.model.AgeGroup;
import org.molgenis.gavinplus.cgd.model.Inheritance;
import org.molgenis.gavinplus.cgd.model.InterventionCategory;
import org.molgenis.gavinplus.cgd.model.ManifestationCategory;

@AutoValue
abstract class CgdRecord {

  public abstract String getGene();

  public abstract int getHgncId();

  public abstract int getEntrezGeneId();

  public abstract String getCondition();

  public abstract List<Inheritance> getInheritance();

  public abstract List<AgeGroup> getAgeGroup();

  @Nullable
  @CheckForNull
  public abstract String getAllelicConditions();

  public abstract List<ManifestationCategory> getManifestationCategories();

  public abstract List<InterventionCategory> getInterventionCategories();

  @Nullable
  @CheckForNull
  public abstract String getComments();

  public abstract String getInterventionRationale();

  public abstract List<Integer> getReferences();

  public static Builder builder() {
    return new AutoValue_CgdRecord.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setGene(String newGene);

    public abstract Builder setHgncId(int newHgncId);

    public abstract Builder setEntrezGeneId(int newEntrezGeneId);

    public abstract Builder setCondition(String newCondition);

    public abstract Builder setInheritance(List<Inheritance> newInheritance);

    public abstract Builder setAgeGroup(List<AgeGroup> newAgeGroup);

    public abstract Builder setAllelicConditions(String newAllelicConditions);

    public abstract Builder setManifestationCategories(
        List<ManifestationCategory> newManifestationCategories);

    public abstract Builder setInterventionCategories(
        List<InterventionCategory> newInterventionCategories);

    public abstract Builder setComments(String newComments);

    public abstract Builder setInterventionRationale(String newInterventionRationale);

    public abstract Builder setReferences(List<Integer> newReferences);

    public abstract CgdRecord build();
  }
}
