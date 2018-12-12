package javaprogramdesign.chapter11.bank19;

public class Loan {
   private double balance, monthlyrate, monthlypmt;
   private int pmtsleft;
   private boolean isdomestic;

   public Loan(double amt, double yearlyrate, int numyears, boolean isdomestic) {
      this.balance = amt;
      pmtsleft = numyears * 12;
      this.isdomestic = isdomestic;
      monthlyrate = yearlyrate / 12.0; 
      monthlypmt = (amt*monthlyrate) / 
            (1-Math.pow(1+monthlyrate, -pmtsleft));
   }

   public double remainingPrincipal() {
      return balance;
   }

   public int paymentsLeft() {
      return pmtsleft;
   }

   public boolean isDomestic() {
      return isdomestic;
   }

   public double monthlyPayment() { 
      return monthlypmt;
   }

   public void makePayment() {
      balance = balance + (balance*monthlyrate) - monthlypmt;
      pmtsleft--;
   }

   public static void main(String[] args) {
      Loan n = new Loan(100, 1.2, 1, true);
      System.out.println(n.monthlyPayment());
      int count=0;
      while (n.paymentsLeft()>0) {
         count++;
         n.makePayment();
         System.out.println(count + ": " + n.remainingPrincipal());
      }
   }
}
