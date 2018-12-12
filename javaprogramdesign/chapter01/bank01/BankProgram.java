package javaprogramdesign.chapter01.bank01;

import java.util.*;

public class BankProgram {
   private HashMap<Integer,Integer> accounts = new HashMap<>();
   private double rate = 0.01;
   private int nextacct = 0;
   private int current = 0;
   private Scanner scanner;
   private boolean done = false;

   public static void main(String[] args) {
      BankProgram program = new BankProgram();
      program.run();
   }

   private void run() {
      scanner = new Scanner(System.in);
      while (!done) {
         System.out.print("Enter command (0=quit, 1=new, 2=select, 3=deposit, 4=loan, 5=show, 6=interest): ");
         int cnum = scanner.nextInt();
         processCommand(cnum);
      }
      scanner.close();
   }

   private void processCommand(int cnum) {
      if      (cnum == 0) quit();
      else if (cnum == 1) newAccount();
      else if (cnum == 2) select();
      else if (cnum == 3) deposit();
      else if (cnum == 4) authorizeLoan();
      else if (cnum == 5) showAll();
      else if (cnum == 6) addInterest();
      else
         System.out.println("illegal command");
   }

   private void quit() {  
      done = true;
      System.out.println("Goodbye!");
   }

   private void newAccount() {
      current = nextacct++;
      accounts.put(current, 0);
      System.out.println("Your new account number is " + current);
   }

   private void select() {
      System.out.print("Enter account#: ");
      current = scanner.nextInt();
      int balance = accounts.get(current);
      System.out.println("The balance of account " + current + " is " + balance);
   }

   private void deposit() {
      System.out.print("Enter deposit amount: ");
      int amt = scanner.nextInt();
      int balance = accounts.get(current);
      accounts.put(current, balance+amt);      
   }

   private void authorizeLoan() {
      System.out.print("Enter loan amount: ");
      int loanamt = scanner.nextInt();
      int balance = accounts.get(current);
      if (balance >= loanamt / 2)
         System.out.println("Your loan is approved");
      else
         System.out.println("Your loan is denied");
   }

   private void showAll() {
      Set<Integer> accts = accounts.keySet();
      System.out.println("The bank has " + accts.size() + " accounts.");
      for (int i : accts)
         System.out.println("\tAccount " + i + ": balance=" + accounts.get(i));
   }

   private void addInterest() {
      Set<Integer> accts = accounts.keySet();
      for (int i : accts) {
         int balance = accounts.get(i);
         int newbalance = (int) (balance * (1 + rate));
         accounts.put(i, newbalance);
      }
   }
}

