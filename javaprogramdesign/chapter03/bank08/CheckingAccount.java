package javaprogramdesign.chapter03.bank08;

public abstract class CheckingAccount extends AbstractBankAccount {

   protected CheckingAccount(int acctnum) {
      super(acctnum);
   }

   public boolean hasEnoughCollateral(int loanamt) {
      return balance >= 2 * loanamt / 3;
   }

   public abstract String toString(); 
   public abstract void addInterest();
}


