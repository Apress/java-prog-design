package javaprogramdesign.chapter10.bank18;

public class BankAccountAdapter implements FBIAcctInfo {
   private BankAccount ba;

   public BankAccountAdapter(BankAccount ba) {
      this.ba = ba;
   }

   public int balance() {
      return ba.getBalance() / 100;
   }

   public boolean isForeign() {
      return ba.isForeign();
   }

   public String acctType() {
      return "deposit";
   }
}
