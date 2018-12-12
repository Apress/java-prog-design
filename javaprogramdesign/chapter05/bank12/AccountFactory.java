package javaprogramdesign.chapter05.bank12;

public interface AccountFactory {
   static BankAccount createSavings(int acctnum) {
      return new SavingsAccount(acctnum);
   }

   static BankAccount createRegularChecking(int acctnum) {
      return new RegularChecking(acctnum);
   }

   static BankAccount createInterestChecking(int acctnum) {
      return new InterestChecking(acctnum);
   }

   static BankAccount createAccount(int type, int acctnum) {
      BankAccount ba;
      if (type == 1) 
         ba = createSavings(acctnum);
      else if (type == 2) 
         ba = createRegularChecking(acctnum);
      else
         ba = createInterestChecking(acctnum);
      return ba;
   }
}
