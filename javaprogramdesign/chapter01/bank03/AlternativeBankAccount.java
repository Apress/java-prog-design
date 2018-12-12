package javaprogramdesign.chapter01.bank03;

// This is a version of BankAccount that uses
// public variables in lieu of methods.
// It is an example of bad design.

public class AlternativeBankAccount {
   public int acctnum;
   public int balance = 0;
   public boolean isforeign = false;

   public AlternativeBankAccount(int a) {
      acctnum = a;
   }
}
