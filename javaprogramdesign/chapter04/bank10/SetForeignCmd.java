package javaprogramdesign.chapter04.bank10;

import java.util.Scanner;

public class SetForeignCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      System.out.print("Enter 1 for foreign, 2 for domestic: ");
      int val = sc.nextInt();
      boolean isforeign = (val == 1);
      bank.setForeign(current, isforeign); 
      return current;
   }

   public String toString() {
      return "setforeign";
   }
}

