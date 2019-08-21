package org.molgenis.gavinplus.cgd.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Inheritance {
  AD, AR, BG, DIGENIC, MATERNAL, METHYLATION, MULTIGENIC, XL, YL;

  private static final Pattern PATTERN = Pattern.compile("(.+?) \\(.+?\\)");

  public static Inheritance get(String token) {
    Matcher matcher = PATTERN.matcher(token);
    if (matcher.matches()) {
      token = matcher.group(1);
    }

    switch (token) {
      case "AD":
        return AD;
      case "AR":
        return AR;
      case "BG":
        return BG;
      case "Digenic":
        return DIGENIC;
      case "Maternal":
        return MATERNAL;
      case "Methylation":
        return METHYLATION;
      case "Multigenic":
        return MULTIGENIC;
      case "XL":
        return XL;
      case "YL":
        return YL;
      default:
        return null;
    }
  }
}
