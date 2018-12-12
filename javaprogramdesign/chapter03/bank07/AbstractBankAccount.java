package javaprogramdesign.chapter03.bank07;

public abstract class AbstractBankAccount implements BankAccount {
   protected int acctnum;
   protected int balance = 0;
   protected boolean isforeign = false;
   
   protected AbstractBankAccount(int acctnum) {
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

   public int compareTo(BankAccount ba) {
      int bal1 = getBalance();
      int bal2 = ba.getBalance();
      if (bal1 == bal2)
         return getAcctNum() - ba.getAcctNum();
      else
         return bal1 - bal2;
   } 
   
   public boolean equals(Object obj) {
      if (! (obj instanceof BankAccount))
         return false;
      BankAccount ba = (BankAccount) obj;
      return getAcctNum() == ba.getAcctNum();
   }
   
   public abstract boolean hasEnoughCollateral(int loanamt);
   public abstract String toString();
   public abstract void addInterest();
}











