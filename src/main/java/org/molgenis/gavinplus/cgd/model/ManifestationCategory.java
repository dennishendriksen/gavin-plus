package org.molgenis.gavinplus.cgd.model;

public enum ManifestationCategory {
  ALLERGY_IMMUNOLOGY_INFECTIOUS,
  AUDIOLOGIC_OTOLARYNGOLOGIC,
  BIOCHEMICAL,
  CARDIOVASCULAR,
  CRANIOFACIAL,
  DENTAL,
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
  PULMONARY,
  RENAL;

  public static ManifestationCategory get(String token) {
    switch (token) {
      case "Allergy/Immunology/Infectious":
        return ALLERGY_IMMUNOLOGY_INFECTIOUS;
      case "Audiologic/Otolaryngologic":
        return AUDIOLOGIC_OTOLARYNGOLOGIC;
      case "Biochemical":
        return BIOCHEMICAL;
      case "Cardiovascular":
        return CARDIOVASCULAR;
      case "Craniofacial":
        return CRANIOFACIAL;
      case "Dental":
        return DENTAL;
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
      case "Pulmonary":
        return PULMONARY;
      case "Renal":
        return RENAL;
      default:
        return null;
    }
  }
}
