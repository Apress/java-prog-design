package javaprogramdesign.chapter08.bank17;

import java.util.Random;

public class GoodCustomerAuthorizer extends AuthorizerWrapper {
   private boolean isgood;

   public GoodCustomerAuthorizer(LoanAuthorizer auth) {
      super(auth);
      // For simplicity, mock up the customer status
      // associated with the owner of the bank account.
      Random rnd = new Random();
      isgood = rnd.nextBoolean(); 
   }

   public boolean authorizeLoan(int amt) {
      if (isgood && amt < 200000) 
         return true;
      else
         return auth.authorizeLoan(amt);
   }
}
