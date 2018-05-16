package org.apache.maven.zopa;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class LoanCalculationTest {
   
   private LoanCalculation loanCalculation;
   private Lender[] lendersList;
   private BigDecimal loanAmount;
   
   @Before
   public void setUp(){
      lendersList = new Lender[7];
      loanCalculation = new LoanCalculation();
      lendersList[0] = new Lender("Sofia",BigDecimal.valueOf(0.01),BigDecimal.valueOf(500));
      lendersList[1] = new Lender("Andrea",BigDecimal.valueOf(0.07),BigDecimal.valueOf(600));
      lendersList[2] = new Lender("Jhon",BigDecimal.valueOf(0.05),BigDecimal.valueOf(50));
      lendersList[3] = new Lender("Marc",BigDecimal.valueOf(0.06),BigDecimal.valueOf(400));
      
   }
   
   @Test
   public void shuldCalculateLoanLowTest() throws Exception{
      loanAmount=BigDecimal.valueOf(100);
      Loan loan =loanCalculation.calculateLoan(lendersList, loanAmount);
      assertEquals(BigDecimal.valueOf(1.5),loan.getInterest());
      assertEquals(BigDecimal.valueOf(2.83),loan.getMonthLoan()); 
      assertEquals(BigDecimal.valueOf(101.55), loan.getTotalLoan()); 
   }
   
   @Test
   public void shuldCalculateLoanMidiumTest() throws Exception{
      loanAmount=BigDecimal.valueOf(1000);
      Loan loan =loanCalculation.calculateLoan(lendersList, loanAmount);
      assertEquals(BigDecimal.valueOf(6.0),loan.getInterest());
      assertEquals(BigDecimal.valueOf(29.55),loan.getMonthLoan()); 
      assertEquals(BigDecimal.valueOf(1063.53), loan.getTotalLoan()); 
   }
   
   @Test
   public void shuldCalculateLoanTest() throws Exception{
      loanAmount=BigDecimal.valueOf(1500);
      Loan loan =loanCalculation.calculateLoan(lendersList, loanAmount);
      assertEquals(BigDecimal.valueOf(6.9),loan.getInterest());
      assertEquals(BigDecimal.valueOf(44.79),loan.getMonthLoan()); 
      assertEquals(BigDecimal.valueOf(1611.96), loan.getTotalLoan()); 
   }
   
   @Test(expected = Exception.class)
   public void shuldThrowException() throws Exception{
      loanAmount=BigDecimal.valueOf(10000);
      loanCalculation.calculateLoan(lendersList, loanAmount);
   }

}
