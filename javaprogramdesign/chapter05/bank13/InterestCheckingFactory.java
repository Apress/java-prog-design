package javaprogramdesign.chapter05.bank13;

public class InterestCheckingFactory implements AccountFactory {
   public BankAccount create(int acctnum) {
      return new InterestChecking(acctnum);
   }
}
