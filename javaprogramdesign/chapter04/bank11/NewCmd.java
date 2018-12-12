package javaprogramdesign.chapter04.bank11;

import java.util.Scanner;

public class NewCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      System.out.print("Enter account type(1=savings, 2=checking, 3=interest checking): ");
      int type = sc.nextInt();
      boolean isforeign = requestForeign(sc);
      current = bank.newAccount(type, isforeign);
      System.out.println("Your new account number is " + current);
      return current;
   }

   public String toString() {
      return "new";
   }

   private boolean requestForeign(Scanner sc) {
      System.out.print("Enter 1 for foreign, 2 for domestic: ");
      int val = sc.nextInt();
      return (val == 1);
   }
}

