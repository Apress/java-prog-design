package javaprogramdesign.chapter05.bank13;

public interface AccountFactory {
   BankAccount create(int acctnum);

   static BankAccount createAccount(int type, int acctnum) {
      AccountFactory af;
      if (type == 1) 
         af = new SavingsFactory();
      else if (type == 2)
         af = new RegularCheckingFactory();
      else
         af = new InterestCheckingFactory();
      return af.create(acctnum);
   }
}
