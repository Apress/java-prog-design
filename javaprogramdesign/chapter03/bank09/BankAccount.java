package javaprogramdesign.chapter03.bank09;

public interface BankAccount extends Comparable<BankAccount> { 
   int getAcctNum();
   int getBalance();   
   void deposit(int amt);
   boolean isForeign();
   void setForeign(boolean isforeign);
   boolean hasEnoughCollateral(int loanamt);
   String toString();
   void addInterest();

   static BankAccount createSavingsWithDeposit(int acctnum, int n) {
      BankAccount ba = new SavingsAccount(acctnum);
      ba.deposit(n);
      return ba;
   }

   default boolean isEmpty() {
      return getBalance() == 0;
   }
}
