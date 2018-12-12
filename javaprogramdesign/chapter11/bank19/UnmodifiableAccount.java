package javaprogramdesign.chapter11.bank19;

public class UnmodifiableAccount extends BankAccountWrapper {

   public UnmodifiableAccount(BankAccount ba) {      
      super(ba); 
   }

   public void deposit(int amt) {
      throw new UnsupportedOperationException();
   }

   //   public void addInterest() {
   //      throw new UnsupportedOperationException();
   //   }

   public void setForeign(boolean isforeign) {
      throw new UnsupportedOperationException();
   }
}

