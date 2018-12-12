package javaprogramdesign.chapter11.bank19;

public class InputController {
   private Bank bank;
   private int current = 0;

   public InputController(Bank bank) {
      this.bank = bank;
   }

   public String newCmd(int type, boolean isforeign) {
      int acctnum = bank.newAccount(type, isforeign);
      current = acctnum;
      return "Your new account number is " + acctnum;
   }

   public String selectCmd(int acctnum) {
      current = acctnum;
      int balance = bank.getBalance(current);
      return "Your balance is " + balance;
   }

   public String depositCmd(int amt) {
      bank.deposit(current, amt);
      return "Amount deposited";
   }

   public String loanCmd(int amt) {
      boolean ok = bank.authorizeLoan(current, amt);
      return ok ? "Your loan is approved" : "Your loan is denied";
   }

   public String showCmd() {
      return bank.toString();
   }

   public String interestCmd() {
      bank.addInterest();
      return "Interest added";
   }

   public String foreignCmd(boolean isforeign) {
      bank.setForeign(current, isforeign);
      return "Account is now " + (isforeign ? "foreign" : "domestic");
   }
}
