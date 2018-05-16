package org.apache.maven.zopa;

import java.math.BigDecimal;

public class Loan {

   private BigDecimal interest;
   private BigDecimal totalLoan;
   private BigDecimal monthLoan;

   public Loan() {

   }

   public BigDecimal getInterest() {
      return interest;
   }

   public void setInterest(BigDecimal interest) {
      this.interest = interest;
   }

   public BigDecimal getTotalLoan() {
      return totalLoan;
   }

   public void setTotalLoan(BigDecimal totalLoan) {
      this.totalLoan = totalLoan;
   }

   public BigDecimal getMonthLoan() {
      return monthLoan;
   }

   public void setMonthLoan(BigDecimal monthLoan) {
      this.monthLoan = monthLoan;
   }

}
