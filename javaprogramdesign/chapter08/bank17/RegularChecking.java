package javaprogramdesign.chapter08.bank17;

public class RegularChecking extends CheckingAccount {

   public RegularChecking(int acctnum) {
      super(acctnum);
   }

   protected String accountType() {
      return "Regular checking";
   }

   protected double interestRate() {
      return 0.0;
   }
}

