package javaprogramdesign.chapter08.bank17;

import java.util.Random;

public class CreditScoreAuthorizer extends AuthorizerWrapper {
   private int score;

   public CreditScoreAuthorizer(LoanAuthorizer auth) {
      super(auth);
      // For simplicity, mock up the credit score
      // associated with the owner of the bank account.
      Random rnd = new Random();
      this.score = 300 + rnd.nextInt(500);
   }

   public boolean authorizeLoan(int amt) {
      if (score > 700 && amt < 1000000) 
         return true;
      else if (score < 500)
         return false;
      else
         return auth.authorizeLoan(amt);
   }
}
