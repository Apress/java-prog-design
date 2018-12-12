package javaprogramdesign.chapter04.bank11;

import java.util.Scanner;

public class InterestCmd implements InputCommand {
   public int execute(Scanner sc, Bank bank, int current) {
      bank.addInterest();     
      return current;
   }

   public String toString() {
      return "interest";
   }
}

