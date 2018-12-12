package javaprogramdesign.chapter04.bank10;

import java.util.Scanner;

public class LoanCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      System.out.print("Enter loan amount: ");
      int amt = sc.nextInt();
      boolean ok = bank.authorizeLoan(current, amt);
      if (ok) 
         System.out.println("Your loan is approved");
      else
         System.out.println("Your loan is denied");    
      return current;
   }

   public String toString() {
      return "loan";
   }
}

