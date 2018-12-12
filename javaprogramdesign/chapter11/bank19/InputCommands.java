package javaprogramdesign.chapter11.bank19;

import java.util.Scanner;

public enum InputCommands implements InputCommand {
   QUIT("quit", (sc, controller)->{
      sc.close();
      return "Goodbye!";
   }),
   NEW("new", (sc, controller)->{
      printMessage();
      int type = sc.nextInt();
      boolean isforeign = requestForeign(sc);
      return controller.newCmd(type, isforeign);
   }),
   SELECT("select", (sc, controller)->{
      System.out.print("Enter account#: ");
      int num = sc.nextInt();
      return controller.selectCmd(num);
   }),
   DEPOSIT("deposit", (sc, controller)->{
      System.out.print("Enter deposit amount: ");
      int amt = sc.nextInt();
      return controller.depositCmd(amt);    
   }),
   LOAN("loan", (sc, controller)->{
      System.out.print("Enter loan amount: ");
      int amt = sc.nextInt();
      return controller.loanCmd(amt);
   }),
   SHOW("show", (sc, controller)->{         
      return controller.showCmd();
   }),
   INTEREST("interest", (sc, controller)-> {         
      return controller.interestCmd();   
   }),
   SET_FOREIGN("setforeign", (sc, controller)-> {
      return controller.foreignCmd(requestForeign(sc));   
   });

   private String name;
   private InputCommand cmd;

   private InputCommands(String name, InputCommand cmd) {
      this.name = name;
      this.cmd = cmd;
   }

   public String execute(Scanner sc, InputController controller) {
      return cmd.execute(sc, controller);
   }

   public String toString() {
      return name;
   }

   private static boolean requestForeign(Scanner sc) {
      System.out.print("Enter 1 for foreign, 2 for domestic: ");
      int val = sc.nextInt();
      return (val == 1);
   }

   private static String message;
   static {
      AccountFactory[] factories = AccountFactories.values();
      message = "Enter Account Type (";
      for (int i=0; i<factories.length-1; i++)
         message += (i+1) + "=" + factories[i] + ", ";
      message += factories.length + "=" + factories[factories.length-1] +")";
   }

   private static void printMessage() {
      System.out.print(message);
   }
}
