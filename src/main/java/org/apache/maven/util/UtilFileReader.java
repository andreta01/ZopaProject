package org.apache.maven.util;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import org.apache.maven.zopa.Lender;

import com.opencsv.CSVReader;

/**
 * Class to manage the Reading the file
 * 
 * @author andrea.ortiz
 *
 */
public class UtilFileReader {

   private static final char SEPARATOR = ',';
   private static final String path = "C:/Temp/";

   private UtilFileReader() {

   }

   /**
    * Method to get the information of the file and sort the list
    * 
    * @param fileName
    * @return
    * @throws IOException
    */
   public static Lender[] fileTransformer(String fileName) throws IOException {
      Lender[] lenderList = new Lender[7];
      CSVReader reader = null;
      try {
         reader = new CSVReader(new FileReader(path + fileName), SEPARATOR);
         String[] nextLine = null;
         int count = 0;
         while ((nextLine = reader.readNext()) != null) {
            if (!nextLine[0].toString().equals("Lender")) {
               lenderList[count] = new Lender(nextLine[0].toString(), BigDecimal.valueOf(Float.parseFloat(nextLine[1])).setScale(3, RoundingMode.CEILING),
                     BigDecimal.valueOf(Float.parseFloat(nextLine[2])).setScale(3, RoundingMode.CEILING));
               count++;
            }
         }
         Arrays.sort(lenderList);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (null != reader) {
            reader.close();
         }
      }
      return lenderList;
   }
}
