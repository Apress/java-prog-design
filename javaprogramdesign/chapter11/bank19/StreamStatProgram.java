package javaprogramdesign.chapter11.bank19;

import java.util.Map;

public class StreamStatProgram {
   public static void main(String[] args) {
      SavedBankInfo info = new SavedBankInfo("bank19.info");
      Map<Integer,BankAccount> accounts = info.getAccounts();
      int nextacct = info.nextAcctNum();
      Bank bank = new Bank(accounts, nextacct);
      StreamStatModel m = new StreamStatModel(bank);
      StreamStatController c = new StreamStatController(m);
      StreamStatView v = new StreamStatView(c);
      v.run();      
   }
}
