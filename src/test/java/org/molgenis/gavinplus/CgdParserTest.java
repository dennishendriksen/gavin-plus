package org.molgenis.gavinplus;

import org.molgenis.gavinplus.cgd.CgdParser;
import org.molgenis.gavinplus.cgd.CgdParserFactory;
import org.springframework.util.ResourceUtils;
import org.testng.annotations.Test;

public class CgdParserTest {

  @Test
  public void testStream() throws Exception {
    try (CgdParser cgdParser = CgdParserFactory
        .create(ResourceUtils.getFile("classpath:CGD.txt.gz"))) {
      cgdParser.stream().count();
    }
  }
}