package javaprogramdesign.chapter04.bank10;

import java.util.Scanner;

public class DepositCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      System.out.print("Enter deposit amount: ");
      int amt = sc.nextInt();
      bank.deposit(current, amt);    
      return current;
   }

   public String toString() {
      return "deposit";
   }
}

