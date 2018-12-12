package javaprogramdesign.chapter07.bank16;

import java.util.Map;
import java.util.function.*;

public class IteratorStatProgram {
   public static void main(String[] args) {   
      SavedBankInfo info = new SavedBankInfo("bank16.info");
      Map<Integer,BankAccount> accounts = info.getAccounts();
      int nextacct = info.nextAcctNum();
      Bank bank = new Bank(accounts, nextacct);
      IteratorAccountStats stats = new IteratorAccountStats(bank);

      System.out.println("Here are the accounts.");
      stats.printAccounts1();
      System.out.println("Here are those accounts again.");
      stats.printAccounts2();
      System.out.println("Here are those accounts again.");
      stats.printAccounts3();
      System.out.println("Here are those accounts again.");
      stats.visit1(ba->System.out.println(ba));

      Predicate<BankAccount> pred = ba -> ba.fee() == 0;      

      System.out.println("Here are the domestic accounts.");
      stats.printAccounts4(pred);
      System.out.println("Here are the domestic accounts again.");
      stats.printAccounts5(pred);
      System.out.println("Here are the domestic accounts again.");
      stats.visit3(pred, ba->System.out.println(ba));

      System.out.println("The max balance of all accounts is " + stats.maxBalance1());
      System.out.println("The max balance of all accounts is " + stats.maxBalance2());
      System.out.println("The max balance of all accounts is " + stats.maxBalance3a());
      System.out.println("The max balance of all accounts is " + stats.maxBalance3b());
      System.out.println("The max balance of all domestic accounts is " + stats.maxBalance4(pred));
      System.out.println("The max balance of all domestic accounts is " + stats.maxBalance5(pred));

      Visitor<BankAccount,Integer> v = new Visitor<BankAccount,Integer>() {
         private int max = 0;         
         public void accept(BankAccount ba) {
            int bal = ba.getBalance();
            if (bal > max) 
               max = bal;
         }         
         public Integer result() {
            return max;
         }
      };

      System.out.println("The max balance of all accounts is " + stats.visit2(v));
      System.out.println("The max balance of all accounts is " + stats.maxBalance3c());
      System.out.println("The max balance of all domestic accounts is " + stats.visit4(pred, v));
   }
}
