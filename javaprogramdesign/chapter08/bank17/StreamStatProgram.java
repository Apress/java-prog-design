package javaprogramdesign.chapter08.bank17;

import java.util.Map;
import java.util.function.Predicate;

public class StreamStatProgram {
   public static void main(String[] args) {
      SavedBankInfo info = new SavedBankInfo("bank.info");
      Map<Integer,BankAccount> accounts = info.getAccounts();
      int nextacct = info.nextAcctNum();
      Bank bank = new Bank(accounts, nextacct);
      StreamAccountStats stats = new StreamAccountStats(bank);
      Predicate<BankAccount> pred = ba -> ba.fee() == 0;      
      System.out.println("The max balance of the domestic accounts is " + stats.maxBalance6(pred));

      System.out.println("Here are the domestic accounts.");
      stats.printAccounts6(pred);
      System.out.println("Here are the domestic accounts again.");
      stats.printAccounts7(pred);
   }
}
