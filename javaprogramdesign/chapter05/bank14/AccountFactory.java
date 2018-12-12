package javaprogramdesign.chapter05.bank14;

public interface AccountFactory {
   BankAccount create(int acctnum);

   static AccountFactory[] factories = AccountFactories.values();

   static BankAccount createAccount(int type, int acctnum) {
      AccountFactory af = factories[type-1];  //account types begin at 1
      return af.create(acctnum);
   }
}
