package javaprogramdesign.chapter11.bank19;

import java.util.*;

public class BankClient {
   private Scanner scanner;
   private InputController controller;
   private InputCommand[] commands = InputCommands.values();

   public BankClient(Scanner scanner, InputController controller) {
      this.scanner = scanner;
      this.controller = controller;
   }

   public void run() {
      String usermessage = constructMessage();
      String response = "";
      while (!response.equals("Goodbye!")) {
         System.out.print(usermessage);
         int cnum = scanner.nextInt();
         InputCommand cmd = commands[cnum];
         response = cmd.execute(scanner, controller);
         System.out.println(response);
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
}
