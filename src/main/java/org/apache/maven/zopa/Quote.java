package org.apache.maven.zopa;

import java.math.BigDecimal;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.maven.util.UtilFileReader;

public class Quote {

   private static LoanCalculation loanCalculation;

   public static void main(String[] args) {

      try {
         validateParams(args);
         String nameFile = args[0];
         BigDecimal loanAmount = BigDecimal.valueOf(Float.parseFloat(args[1]));
         loanCalculation = new LoanCalculation();
         Lender[] lendersList = UtilFileReader.fileTransformer(nameFile);
         Loan loan = loanCalculation.calculateLoan(lendersList, loanAmount);
         System.out.println("Requested amount: £" + loanAmount);
         System.out.println("Rate: " + loan.getInterest() + "%");
         System.out.println("Monthly repayment: £" + loan.getMonthLoan());
         System.out.println("Total repayment: £" + loan.getTotalLoan());
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

   private static void validateParams(String[] args) throws Exception {
      if (ArrayUtils.isEmpty(args))
         throw new Exception(
               "Error occured while getting parameters from args, imcomplete information. Parameters are null.");

      if (args.length < 2)
         throw new Exception("Please provide the correct parameters");

      String dig = args[1].substring(args[1].length() - 2, args[1].length());
      if (dig.equals("00")) {
         int loanAmount = Integer.parseInt(args[1]);

         if (loanAmount >= 1000 && loanAmount <= 15000) {
            
         } else {
            throw new Exception("Sorry, only able to request a loan betwen £1000 and £15000");
         }
      } else {
         throw new Exception("Sorry, only able to request a loan of any £100");
      }
   }

}
