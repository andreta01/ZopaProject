package org.apache.maven.zopa;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class LoanCalculation {

   private static final BigDecimal ONE = BigDecimal.ONE;
   private static final BigDecimal ZERO = BigDecimal.ZERO;
   private final BigDecimal loansMonths = BigDecimal.valueOf(Integer.parseInt("36"));

   public Loan calculateLoan(Lender[] lendersList, BigDecimal loanAmount) throws Exception {

      Loan loan = new Loan();
      loan.setInterest(ZERO);
      loan.setMonthLoan(ZERO);
      loan.setTotalLoan(ZERO);
      BigDecimal lenderLoan;
      BigDecimal rateLoan;
      BigDecimal totalLoan;
      BigDecimal monthLoan;
      BigDecimal balance = loanAmount;
      BigDecimal lenderAvailable;
      for (int i = 0; i < 7; i++) {
         if (balance.intValue() > 0) {
            lenderAvailable = lendersList[i].getAviable();
            if (lenderAvailable.intValue() <= balance.intValue()) {
               lenderLoan = lenderAvailable;
            } else {
               lenderLoan = balance;
            }
            rateLoan = lendersList[i].getRate().divide(BigDecimal.valueOf(12), 6, RoundingMode.HALF_UP);
            loan.setInterest(rateLoan);
            int months = -loansMonths.intValue();
            BigDecimal result = lenderLoan.multiply(rateLoan)
                  .divide(ONE.subtract(rateLoan.add(ONE).pow(months, new MathContext(6))), 6, RoundingMode.HALF_UP);
            monthLoan = result;
            loan.setMonthLoan(monthLoan.add(loan.getMonthLoan()).setScale(2, RoundingMode.CEILING));
            totalLoan = result.multiply(loansMonths);
            loan.setTotalLoan(totalLoan.add(loan.getTotalLoan()).setScale(2, RoundingMode.CEILING));

            balance = balance.subtract(lenderLoan);
         }
      }
      loan.setInterest(loan.getTotalLoan().subtract(loanAmount).multiply(BigDecimal.valueOf(100))
            .divide(loan.getTotalLoan(), 1, RoundingMode.HALF_UP));
      if (balance.intValue() > 0) { 
         throw new Exception(
            "We apologize, it is not possible to provide a quote at that time."); }
      return loan;
   }

}
