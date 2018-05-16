package org.apache.maven.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.maven.zopa.Lender;
import org.junit.Before;
import org.junit.Test;

public class UtilFileReaderTest {
   
   @Before
   public void setUp(){
      
   }
   
   @Test
   public void shoudReadFile() throws IOException{
      String nameFile = "market.csv";
      Lender[] lenders = UtilFileReader.fileTransformer(nameFile );
      assertNotNull(lenders);
      assertNotNull(lenders[0]);
      assertEquals(BigDecimal.valueOf(Float.parseFloat("0.069")).setScale(3, RoundingMode.CEILING) ,lenders[0].getRate());
   }
   
   @Test
   public void shoudFailReadFile() throws IOException{
      String nameFile = "";
      Lender[] lenders = UtilFileReader.fileTransformer(nameFile );
      assertNotNull(lenders);
   }

}
