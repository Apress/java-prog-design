package javaprogramdesign.chapter02.bank05;

import java.util.*;

public class BankProgram {
   public static void main(String[] args) {
      HashMap<Integer,BankAccount> accounts = new HashMap<>();
      Bank bank = new Bank(accounts, 0);
      Scanner scanner = new Scanner(System.in);
      BankClient client = new BankClient(scanner, bank);
      client.run();
   }
}
