package javaprogramdesign.chapter11.bank19;

public class AllController implements BankObserver {
   private Bank bank;
   private AllView view;

   public AllController(Bank bank) {
      this.bank = bank;
      bank.addObserver(BankEvent.NEW, this);
      bank.addObserver(BankEvent.DEPOSIT, this);
      bank.addObserver(BankEvent.SETFOREIGN, this);
      bank.addObserver(BankEvent.INTEREST, this);
   }

   // methods called by the view
   public void setView(AllView view) {
      this.view = view;
      refreshAccounts();
   }
   public void interestButton() {
      bank.addInterest();
   }  

   // method called by the model
   public void update(BankEvent e, BankAccount ba, int amt) { 
      refreshAccounts();
   }

   private void refreshAccounts() {
      StringBuffer result = new StringBuffer();
      for (BankAccount ba : bank)
         result.append(ba + "\n");
      view.setAccounts(result.toString());
   }
}
