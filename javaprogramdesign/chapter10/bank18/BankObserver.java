package javaprogramdesign.chapter10.bank18;

public interface BankObserver {
   void update(BankEvent event, BankAccount ba, int depositamt);
}

