package javaprogramdesign.chapter10.bank18;

import java.util.Date;

public class SuspiciousAccount extends BankAccountWrapper {   
   public SuspiciousAccount(BankAccount ba) {
      super(ba); 
   }

   public void deposit(int amt) {
      Date d = new Date();
      String msg = "On " + d + " account #" + ba.getAcctNum() + " deposited " + amt; 
      System.out.println(msg);
      ba.deposit(amt);
   }

   public String toString() {
      return "## " + ba.toString();
   }
}

