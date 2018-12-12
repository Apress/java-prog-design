package javaprogramdesign.chapter08.bank17;

public class LoanAdapter implements FBIAcctInfo {
   private Loan ln;

   public LoanAdapter(Loan ln) {
      this.ln = ln;
   }

   public int balance() {
      return (int) (ln.remainingPrincipal() / 100);
   }

   public boolean isForeign() {
      return !ln.isDomestic();
   }

   public String acctType() {
      return "loan";
   }
}
