package javaprogramdesign.chapter11.bank19;

public abstract class BankAccountWrapper implements BankAccount {
   protected BankAccount ba;

   protected BankAccountWrapper(BankAccount ba) {
      this.ba = ba;
   }

   public int getAcctNum() { 
      return ba.getAcctNum(); 
   }

   public int getBalance() { 
      return ba.getBalance(); 
   }

   public void deposit(int amt) {
      ba.deposit(amt);
   }

   public boolean isForeign() {
      return ba.isForeign();
   }

   public void setForeign(boolean isforeign) {
      ba.setForeign(isforeign);
   }   

   public int compareTo(BankAccount otherba) {
      return ba.compareTo(otherba);
   }

   public boolean hasEnoughCollateral(int loanamt) {
      return ba.hasEnoughCollateral(loanamt);
   }

   public String toString() {
      return ba.toString();
   }

   public int fee() {
      return ba.fee();
   }

   public void addInterest() {
      ba.addInterest();
   }

   public boolean equals(Object obj) {
      return ba.equals(obj);
   }
}

