package org.molgenis.gavinplus.cgd.model;

public enum InterventionCategory {
  ALLERGY_IMMUNOLOGY_INFECTIOUS,
  AUDIOLOGIC_OTOLARYNGOLOGIC,
  BIOCHEMICAL,
  CARDIOVASCULAR,
  DERMATOLOGIC,
  ENDOCRINE,
  GASTROINTESTINAL,
  GENERAL,
  GENITOURINARY,
  HEMATOLOGIC,
  MUSCULOSKELETAL,
  NEUROLOGIC,
  OBSTETRIC,
  ONCOLOGIC,
  OPHTHALMOLOGIC,
  PHARMACOGENOMIC,
  PULMONARY,
  RENAL;

  public static InterventionCategory get(String token) {
    switch (token) {
      case "Allergy/Immunology/Infectious":
        return ALLERGY_IMMUNOLOGY_INFECTIOUS;
      case "Audiologic/Otolaryngologic":
        return AUDIOLOGIC_OTOLARYNGOLOGIC;
      case "Biochemical":
        return BIOCHEMICAL;
      case "Cardiovascular":
        return CARDIOVASCULAR;
      case "Dermatologic":
        return DERMATOLOGIC;
      case "Endocrine":
        return ENDOCRINE;
      case "Gastrointestinal":
        return GASTROINTESTINAL;
      case "General":
        return GENERAL;
      case "Genitourinary":
        return GENITOURINARY;
      case "Hematologic":
        return HEMATOLOGIC;
      case "Musculoskeletal":
        return MUSCULOSKELETAL;
      case "Neurologic":
        return NEUROLOGIC;
      case "Obstetric":
        return OBSTETRIC;
      case "Oncologic":
        return ONCOLOGIC;
      case "Ophthalmologic":
        return OPHTHALMOLOGIC;
      case "Pharmacogenomic":
        return PHARMACOGENOMIC;
      case "Pulmonary":
        return PULMONARY;
      case "Renal":
        return RENAL;
      default:
        return null;
    }
  }
}
