package javaprogramdesign.chapter04.bank10;

import java.util.Scanner;

public class NewCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      System.out.print("Enter account type(1=savings, 2=checking, 3=interest checking): ");
      int type = sc.nextInt();
      System.out.print("Enter 1 for foreign, 2 for domestic: ");
      int val = sc.nextInt();
      boolean isforeign = (val == 1);
      current = bank.newAccount(type, isforeign);
      System.out.println("Your new account number is " + current);
      return current;
   }

   public String toString() {
      return "new";
   }
}

