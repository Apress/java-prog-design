package javaprogramdesign.chapter11.bank19;

public interface LoanAuthorizer {
   boolean authorizeLoan(int amt);

   static LoanAuthorizer getAuthorizer(BankAccount ba) {
      LoanAuthorizer auth = new CollateralAuthorizer(ba);
      auth = new CreditScoreAuthorizer(auth);
      return new GoodCustomerAuthorizer(auth);
   }  
}
