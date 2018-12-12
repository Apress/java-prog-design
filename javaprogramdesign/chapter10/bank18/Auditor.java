package javaprogramdesign.chapter10.bank18;

public class Auditor implements BankObserver {
   public Auditor(Bank bank) {
      bank.addObserver(BankEvent.NEW, this);
      bank.addObserver(BankEvent.SETFOREIGN, this);
   }

   public void update(BankEvent e, BankAccount ba, int depositamt) {
      if (ba.isForeign()) {
         if (e == BankEvent.NEW)
            System.out.println("New foreign account: " 
                  + ba.getAcctNum());
         else 
            System.out.println("Modified foreign account: " 
                  + ba.getAcctNum());
      }
   }
}
