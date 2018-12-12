package javaprogramdesign.chapter03.bank08;

public class RegularChecking extends CheckingAccount {
   public RegularChecking(int acctnum) {
      super(acctnum);
   }

   public String toString() {
      return "Regular checking account " + acctnum + ": balance=" + balance 
            + ", is " + (isforeign ? "foreign" : "domestic");
   }

   public void addInterest() {
      // do nothing
   }
}

