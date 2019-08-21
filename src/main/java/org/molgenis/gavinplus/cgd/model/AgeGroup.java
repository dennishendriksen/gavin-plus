package org.molgenis.gavinplus.cgd.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum AgeGroup {
  PEDIATRIC, ADULT;

  private static final Pattern PATTERN = Pattern.compile("(.+?) \\(.+?\\)");


  public static AgeGroup get(String token) {
    Matcher matcher = PATTERN.matcher(token);
    if (matcher.matches()) {
      token = matcher.group(1);
    }

    switch (token) {
      case "Pediatric":
        return PEDIATRIC;
      case "Adult":
        return ADULT;
      default:
        return null;
    }
  }
}
