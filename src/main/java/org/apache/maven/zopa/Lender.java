package org.apache.maven.zopa;

import java.math.BigDecimal;

public class Lender implements Comparable<Lender>{

   private String lenderName;
   private BigDecimal  rate;
   private BigDecimal aviable;

   public Lender() {

   }

   public Lender(String lenderName, BigDecimal rate, BigDecimal aviable) {
      super();
      this.lenderName = lenderName;
      this.rate = rate;
      this.aviable = aviable;
   }

   public String getLenderName() {
      return lenderName;
   }

   public void setLenderName(String lenderName) {
      this.lenderName = lenderName;
   }

   public BigDecimal getRate() {
      return rate;
   }

   public void setRate(BigDecimal rate) {
      this.rate = rate;
   }

   public BigDecimal getAviable() {
      return aviable;
   }

   public void setAviable(BigDecimal aviable) {
      this.aviable = aviable;
   }

   @Override
   public String toString() {
      return "Lenders [lenderName=" + lenderName + ", rate=" + rate + ", aviable=" + aviable + "]";
   }

   public int compareTo(Lender o) {
      if (rate.floatValue()< o.rate.floatValue()) { return -1; }
      if (rate.floatValue() > o.rate.floatValue()) { return 1; }
      return 0;
   }
}
