package javaprogramdesign.chapter04.bank11;

import java.util.Scanner;

public class QuitCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      sc.close();
      System.out.println("Goodbye!");
      return -1;
   }

   public String toString() {
      return "quit";
   }
}
