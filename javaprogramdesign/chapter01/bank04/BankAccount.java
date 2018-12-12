package javaprogramdesign.chapter01.bank04;

public class BankAccount {
   private double rate = 0.01;
   private int acctnum;
   private int balance = 0;
   private boolean isforeign = false;

   public BankAccount(int acctnum) {
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
      return "Account " + acctnum + ": balance=" + balance 
            + ", is " + (isforeign ? "foreign" : "domestic");
   }

   public void addInterest() {
      balance += (int) (balance * rate);
   }
}
