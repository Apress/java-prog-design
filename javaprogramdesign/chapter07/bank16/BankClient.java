package javaprogramdesign.chapter07.bank16;

import java.util.*;

public class BankClient {
   private Scanner scanner;
   private boolean done = false;
   private Bank bank;
   private int current = 0;
   private InputCommand[] commands = InputCommands.values();

   public BankClient(Scanner scanner, Bank bank) {
      this.scanner = scanner;
      this.bank = bank;
   }

   public void run() {
      String usermessage = constructMessage();
      while (!done) {
         System.out.print(usermessage);
         int cnum = scanner.nextInt();
         processCommand(cnum);
      }
   }

   private String constructMessage() {
      int last = commands.length-1;
      String result = "Enter Account Type (";
      for (int i=0; i<last; i++) 
         result += i + "=" + commands[i] + ", ";
      result += last + "=" + commands[last] + "): ";
      return result;
   }

   private void processCommand(int cnum) {
      InputCommand cmd = commands[cnum];
      current = cmd.execute(scanner, bank, current);
      if (current < 0)
         done = true;
   }
}
