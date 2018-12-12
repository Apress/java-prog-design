package javaprogramdesign.chapter04.bank11;

import java.util.Scanner;

public class ShowCmd implements InputCommand { 
   public int execute(Scanner sc, Bank bank, int current) {
      System.out.println(bank.toString());
      return current;
   }

   public String toString() {
      return "Show";
   }
}

