package javaprogramdesign.chapter10.bank18;

public class SavingsAccount extends AbstractBankAccount {
   public SavingsAccount(int acctnum) {
      super(acctnum);
   }

   protected double collateralRatio() {
      return 1.0 / 2.0;
   }

   protected String accountType() {
      return "Savings";
   }

   protected double interestRate() {
      return 0.01;
   }
}









