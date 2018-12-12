package javaprogramdesign.chapter11.bank19;

import javafx.collections.*;

public class AllController2 implements BankObserver {
   private Bank bank;
   private ObservableList<BankAccount> accounts = FXCollections.observableArrayList();

   public AllController2(Bank bank) {
      this.bank = bank;
      bank.addObserver(BankEvent.NEW, this);
      bank.addObserver(BankEvent.DEPOSIT, this);
      bank.addObserver(BankEvent.SETFOREIGN, this);
      bank.addObserver(BankEvent.INTEREST, this);
      for (BankAccount ba : bank) 
         accounts.add(ba);
   }

   public ObservableList<BankAccount> getAccountList() {
      return accounts;
   }

   // method called by the view
   public void interestButton() {
      bank.addInterest();
   }  

   // method called by the model
   public void update(BankEvent e, BankAccount ba, int amt) { 
      if (e == BankEvent.INTEREST)
         refreshAllAccounts();
      else if (e == BankEvent.NEW)
         accounts.add(ba);
      else {
         int i = accounts.indexOf(ba);
         refreshAccount(i); 
      }
   }

   private void refreshAccount(int i) {
      // a no-op, to force the list to notify its observer
      accounts.set(i, accounts.get(i));
   }

   private void refreshAllAccounts() {
      for (int i=0; i<accounts.size(); i++)
         refreshAccount(i);
   }
}
