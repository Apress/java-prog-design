package javaprogramdesign.chapter04.bank11;

import java.util.Scanner;

public class SetForeignCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      bank.setForeign(current, requestForeign(sc)); 
      return current;
   }

   public String toString() {
      return "setforeign";
   }

   private boolean requestForeign(Scanner sc) {
      System.out.print("Enter 1 for foreign, 2 for domestic: ");
      int val = sc.nextInt();
      return (val == 1);
   }
}

