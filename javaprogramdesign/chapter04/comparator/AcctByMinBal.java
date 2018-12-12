package javaprogramdesign.chapter04.comparator;

import java.util.Comparator;
import javaprogramdesign.chapter04.bank10.BankAccount;

public class AcctByMinBal implements Comparator<BankAccount> {
   public int compare(BankAccount ba1, BankAccount ba2) {
      int bal1 = ba1.getBalance();
      int bal2 = ba2.getBalance();
      if (bal1 == bal2)
         return ba1.getAcctNum() - ba2.getAcctNum();
      else
         return bal2 - bal1;
   }
}

