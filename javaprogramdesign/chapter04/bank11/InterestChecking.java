package javaprogramdesign.chapter04.bank11;

public class InterestChecking implements TypeStrategy {
   public double collateralRatio() {
      return 2.0 / 3.0;
   }

   public String accountType() {
      return "Interest checking";
   }

   public double interestRate() {
      return 0.01;
   }
}
