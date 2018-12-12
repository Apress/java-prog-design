package javaprogramdesign.chapter04.bank11;

public class AbstractBankAccount implements BankAccount {
   private int acctnum;
   private int balance = 0;
   private OwnerStrategy owner = new Domestic();
   private TypeStrategy ts;

   public AbstractBankAccount(int acctnum, TypeStrategy ts) {
      this.acctnum = acctnum;
      this.ts = ts;
   }

   public int getAcctNum() { 
      return acctnum; 
   }

   public int getBalance() { 
      return balance; 
   }

   public boolean isForeign() {
      return owner.isForeign();
   }

   public void setForeign(boolean b) {
      owner = b ? new Foreign() : new Domestic();
   }

   public void deposit(int amt) {
      balance += amt;
   }

   public int compareTo(BankAccount ba) {
      int bal1 = getBalance();
      int bal2 = ba.getBalance();
      if (bal1 == bal2)
         return getAcctNum() - ba.getAcctNum();
      else
         return bal1 - bal2;
   } 

   public boolean hasEnoughCollateral(int loanamt) {
      double ratio = collateralRatio();
      return balance >= loanamt * ratio;
   };

   public String toString() {
      String accttype = accountType();
      return accttype + " account " + acctnum + ": balance=" + balance 
            + ", is " + owner.toString()
            + ", fee=" + fee();
   }

   public  void addInterest() {
      balance += (int) (balance * interestRate());
   }

   public boolean equals(Object obj) {
      if (! (obj instanceof BankAccount))
         return false;
      BankAccount ba = (BankAccount) obj;
      return getAcctNum() == ba.getAcctNum();
   }

   public int fee() {
      return owner.fee();
   }

   private double collateralRatio() {
      return ts.collateralRatio();
   }

   public String accountType() {
      return ts.accountType();
   }

   private double interestRate() {
      return ts.interestRate();
   }
}











