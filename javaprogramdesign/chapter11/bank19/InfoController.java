package javaprogramdesign.chapter11.bank19;

public class InfoController implements BankObserver {
   private Bank bank;
   private int current = 0;
   private InfoView view;

   public InfoController(Bank bank) {
      this.bank = bank;
      bank.addObserver(BankEvent.DEPOSIT, this);
      bank.addObserver(BankEvent.INTEREST, this);
      bank.addObserver(BankEvent.SETFOREIGN, this);
   }

   // methods called by the view
   public void setView(InfoView view) {
      this.view = view;
   }
   public void depositButton(String s) {
      int amt = Integer.parseInt(s);
      bank.deposit(current, amt);
   } 
   public String loanButton(String s) {
      int loanamt = Integer.parseInt(s);
      boolean result = bank.authorizeLoan(current, loanamt);
      return result ? "APPROVED" : "DENIED";   
   }
   public void foreignButton(String s) {
      boolean b = s.equals("Foreign") ? true : false;
      bank.setForeign(current, b);
   }   
   public void selectButton(String s) {
      current = Integer.parseInt(s);
      view.setBalance(Integer.toString(bank.getBalance(current)));
      view.setForeign(bank.isForeign(current));
   }

   // method called by the model
   public void update(BankEvent e, BankAccount ba, int amt) {
      if (e == BankEvent.SETFOREIGN && ba.getAcctNum() == current)
          view.setForeign(ba.isForeign());
      else if (e == BankEvent.INTEREST || ba.getAcctNum() == current)
         view.setBalance(Integer.toString(bank.getBalance(current)));
   }
}
