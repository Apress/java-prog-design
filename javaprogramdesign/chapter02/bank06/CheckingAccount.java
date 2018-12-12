package javaprogramdesign.chapter02.bank06;

public class CheckingAccount implements BankAccount, Comparable<BankAccount> {
   private int acctnum;
   private int balance = 0;
   private boolean isforeign = false;

   public CheckingAccount(int acctnum) {
      this.acctnum = acctnum;
   }

   public int getAcctNum() { 
      return acctnum; 
   }

   public int getBalance() { 
      return balance; 
   }

   public void deposit(int amt) {
      balance += amt;
   }

   public boolean isForeign() {
      return isforeign;
   }

   public void setForeign(boolean b) {
      isforeign = b;
   }

   public boolean hasEnoughCollateral(int loanamt) {
      return balance >= 2 * loanamt / 3;
   }

   public String toString() {
      return "Checking account " + acctnum + ": balance=" + balance 
            + ", is " + (isforeign ? "foreign" : "domestic");
   }

   public void addInterest() {
      // do nothing
   }

   public int compareTo(BankAccount ba) {
      int bal1 = getBalance();
      int bal2 = ba.getBalance();
      if (bal1 == bal2)
         return getAcctNum() - ba.getAcctNum();
      else
         return bal1 - bal2;
   }

   public boolean equals(Object obj) {
      if (! (obj instanceof CheckingAccount))
         return false;
      CheckingAccount ba = (CheckingAccount) obj;
      return getAcctNum() == ba.getAcctNum();
   }
}

