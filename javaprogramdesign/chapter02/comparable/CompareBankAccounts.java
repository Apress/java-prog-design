package javaprogramdesign.chapter02.comparable;

import java.util.*;
import javaprogramdesign.chapter02.bank06.*;

// Compare accounts using their natural order.

public class CompareBankAccounts {
   public static void main(String[] args) {
      ArrayList<BankAccount> accts = initAccts();
      BankAccount maxacct1 = findMax(accts);
      BankAccount maxacct2 = Collections.max(accts);       
      System.out.println("Acct with largest balance is " + maxacct1);
      System.out.println("Acct with largest balance is " + maxacct2);     
   }

   private static ArrayList<BankAccount> initAccts() {
      ArrayList<BankAccount> accts = new ArrayList<>();
      accts.add(new SavingsAccount(0)); accts.get(0).deposit(100); 
      accts.add(new CheckingAccount(1)); accts.get(1).deposit(200); 
      accts.add(new SavingsAccount(2)); accts.get(2).deposit(50); 
      return accts;
   }

   private static BankAccount findMax(ArrayList<BankAccount> a) {
      BankAccount max = a.get(0);
      for (int i=1; i<a.size(); i++) {
         if (a.get(i).compareTo(max) > 0)
            max = a.get(i);
      }
      return max;
   }
}