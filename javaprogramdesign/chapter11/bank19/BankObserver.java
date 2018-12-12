package javaprogramdesign.chapter11.bank19;

public interface BankObserver {
   void update(BankEvent event, BankAccount ba, int depositamt);
}

