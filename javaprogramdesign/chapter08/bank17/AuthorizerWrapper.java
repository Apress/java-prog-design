package javaprogramdesign.chapter08.bank17;

public abstract class AuthorizerWrapper implements LoanAuthorizer {
   protected LoanAuthorizer auth;

   protected AuthorizerWrapper(LoanAuthorizer auth) {
      this.auth = auth;
   }

   public boolean authorizeLoan(int amt) {
      return auth.authorizeLoan(amt);
   }
}
