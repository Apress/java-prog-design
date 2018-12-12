package javaprogramdesign.chapter11.bank19;

public class CreationController implements BankObserver {
   private Bank bank;
   private CreationView view;

   public CreationController(Bank bank) {
      this.bank = bank;
      bank.addObserver(BankEvent.NEW, this);
   }

   // methods called by the view
   void setView(CreationView view) {
      this.view = view;
   }
   public void buttonPressed(int type, boolean isforeign) {
      bank.newAccount(type+1, isforeign);
   }  

   // method called by the model
   public void update(BankEvent e, BankAccount ba,  int amt) {
      view.setTitle("Account " + ba.getAcctNum() + " created");
   }
}

