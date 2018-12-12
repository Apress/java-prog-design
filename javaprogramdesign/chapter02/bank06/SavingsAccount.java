package javaprogramdesign.chapter02.bank06;

public class SavingsAccount implements BankAccount, Comparable<BankAccount> {
   private double rate = 0.01;
   private int acctnum;
   private int balance = 0;
   private boolean isforeign = false;

   public SavingsAccount(int acctnum) {
      this.acctnum = acctnum;
   }

   public int getAcctNum() { 
      return acctnum; 
   }

   public int getBalance() { 
      return balance; 
   }

   public boolean isForeign() {
      return isforeign;
   }

   public void setForeign(boolean b) {
      isforeign = b;
   }

   public void deposit(int amt) {
      balance += amt;
   }

   public boolean hasEnoughCollateral(int loanamt) {
      return balance >= loanamt / 2;
   }

   public String toString() {
      return "Savings account " + acctnum + ": balance=" + balance 
            + ", is " + (isforeign ? "foreign" : "domestic");
   }

   public void addInterest() {
      balance += (int) (balance * rate);
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
      if (! (obj instanceof SavingsAccount))
         return false;
      SavingsAccount ba = (SavingsAccount) obj;
      return getAcctNum() == ba.getAcctNum();
   }
}









