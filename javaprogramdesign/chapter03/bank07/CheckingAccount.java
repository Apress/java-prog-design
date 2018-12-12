package javaprogramdesign.chapter03.bank07;

public class CheckingAccount extends AbstractBankAccount {

   public CheckingAccount(int acctnum) {
      super(acctnum);
   }

   public boolean hasEnoughCollateral(int loanamt) {
      return balance >= 2 * loanamt / 3;
   }

   public String toString() {
      return "Checking account " + acctnum + ": balance=" + balance 
            + ", is " + (isforeign ? "foreign" : "domestic");
   }

   public void addInterest() {
      // do nothing
   }
}


