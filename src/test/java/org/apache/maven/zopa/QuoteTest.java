package org.apache.maven.zopa;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class QuoteTest {
   
   final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
   
   @Before
   public void setUp(){
      System.setOut(new PrintStream(outContent)); 
   }
   @Test
   public void shouldCalculateLoan() throws Exception{
      
      String[] args = new String[] {"market.csv", "1000"};
      Quote.main(args);
      assertTrue(outContent.toString().contains("Requested amount: £1000.0"));
   }
   
   @Test
   public void shuldCalculateLoanTest() throws Exception{
      String[] args = new String[] {"market.csv", "1500"};
      Quote.main(args);
      assertTrue(outContent.toString().contains("Requested amount: £1500.0"));
   }
   
   @Test
   public void shuldThrowException() throws Exception{
      String[] args = new String[] {"market.csv", "10000"};
      Quote.main(args);
      assertTrue(outContent.toString().contains("We apologize, it is not possible to provide a quote at that time."));
   }

   @Test
   public void shuldThrowExceptionTest() throws Exception{
      String[] args = new String[] {"market.csv", "150000"};
      Quote.main(args);
      assertTrue(outContent.toString().contains("Sorry, only able to request a loan betwen £1000 and £15000"));
   }
   
   @Test
   public void shuldThrowExceptionFailTest() throws Exception{
      String[] args = new String[] {"market.csv", "1555"};
      Quote.main(args);
      assertTrue(outContent.toString().contains("Sorry, only able to request a loan of any £100"));
   }
}
