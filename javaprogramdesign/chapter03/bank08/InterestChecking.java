package javaprogramdesign.chapter03.bank08;

public class InterestChecking extends CheckingAccount {
   private double rate = 0.01;

   public InterestChecking(int acctnum) {
      super(acctnum);
   }

   public String toString() {
      return "Interest checking account " + acctnum + ": balance=" + balance 
            + ", is " + (isforeign ? "foreign" : "domestic");
   }

   public void addInterest() {
      balance += (int) (balance * rate);
   }
}

