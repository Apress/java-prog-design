package javaprogramdesign.chapter05.bank13;

public class SavingsFactory implements AccountFactory {
   public BankAccount create(int acctnum) {
      return new SavingsAccount(acctnum);
   }
}
