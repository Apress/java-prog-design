package javaprogramdesign.chapter04.bank11;

public interface BankAccount extends Comparable<BankAccount> { 
   int getAcctNum();
   int getBalance();   
   void deposit(int amt);
   boolean isForeign();
   void setForeign(boolean isforeign);
   boolean hasEnoughCollateral(int loanamt);
   String toString();
   void addInterest();
   int fee();

   static BankAccount createSavingsWithDeposit(int acctnum, int n) {
      TypeStrategy ts = new SavingsAccount();
      BankAccount ba = new AbstractBankAccount(acctnum, ts);
      ba.deposit(n);
      return ba;
   }

   default boolean isEmpty() {
      return getBalance() == 0;
   }
}
