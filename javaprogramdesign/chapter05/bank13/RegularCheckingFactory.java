package javaprogramdesign.chapter05.bank13;

public class RegularCheckingFactory implements AccountFactory {
   public BankAccount create(int acctnum) {
      return new RegularChecking(acctnum);
   }
}
