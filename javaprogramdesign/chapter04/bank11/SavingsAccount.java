package javaprogramdesign.chapter04.bank11;

public class SavingsAccount implements TypeStrategy {
   public double collateralRatio() {
      return 1.0 / 2.0;
   }

   public String accountType() {
      return "Savings";
   }

   public double interestRate() {
      return 0.01;
   }
}

