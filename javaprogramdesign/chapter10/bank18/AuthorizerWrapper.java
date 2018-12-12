package javaprogramdesign.chapter10.bank18;

public abstract class AuthorizerWrapper implements LoanAuthorizer {
   protected LoanAuthorizer auth;

   protected AuthorizerWrapper(LoanAuthorizer auth) {
      this.auth = auth;
   }

   public boolean authorizeLoan(int amt) {
      return auth.authorizeLoan(amt);
   }
}
