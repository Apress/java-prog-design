package javaprogramdesign.chapter10.bank18;

import java.util.*;

public class BankProgram {
   public static void main(String[] args) {
      SavedBankInfo info = new SavedBankInfo("bank18.info");
      Map<Integer,BankAccount> accounts = info.getAccounts();
      int nextacct = info.nextAcctNum();
      Bank bank = new Bank(accounts, nextacct);
      Auditor aud = new Auditor(bank);
      bank.addObserver(BankEvent.DEPOSIT, 
            (event,ba,amt) -> {
               if (amt > 10000000)
                  bank.makeSuspicious(ba.getAcctNum());
            });
      Scanner scanner = new Scanner(System.in);
      BankClient client = new BankClient(scanner, bank);
      client.run();
      info.saveMap(accounts, bank.nextAcctNum());
   }
}

