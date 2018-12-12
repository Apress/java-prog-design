package javaprogramdesign.chapter11.bank19;

import java.util.*;

public class BankProgram {
   public static void main(String[] args) {
      SavedBankInfo info = new SavedBankInfo("bank19.info");
      Map<Integer,BankAccount> accounts = info.getAccounts();
      int nextacct = info.nextAcctNum();
      Bank bank = new Bank(accounts, nextacct);
      Auditor aud = new Auditor(bank);
      bank.addObserver(BankEvent.DEPOSIT, 
            (event,ba,amt) -> {
               if (amt > 10000000)
                  bank.makeSuspicious(ba.getAcctNum());
            });
      InputController controller = new InputController(bank);
      Scanner scanner = new Scanner(System.in);
      BankClient client = new BankClient(scanner, controller);
      client.run();
      info.saveMap(accounts, bank.nextAcctNum());
   }
}

