package javaprogramdesign.chapter11.bank19;

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
