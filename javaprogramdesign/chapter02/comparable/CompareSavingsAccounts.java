package javaprogramdesign.chapter02.comparable;

import java.util.*;
import javaprogramdesign.chapter02.bank06.*;

public class CompareSavingsAccounts {
   public static void main(String[] args) {
      ArrayList<SavingsAccount> accts = initAccts();
      SavingsAccount maxacct1 = findMax(accts);
      SavingsAccount maxacct2 = Collections.max(accts);       
      System.out.println("Acct with largest balance is " + maxacct1);
      System.out.println("Acct with largest balance is " + maxacct2);     
   }

   private static ArrayList<SavingsAccount> initAccts() {
      ArrayList<SavingsAccount> accts = new ArrayList<>();
      accts.add(new SavingsAccount(0)); accts.get(0).deposit(100); 
      accts.add(new SavingsAccount(1)); accts.get(1).deposit(200); 
      accts.add(new SavingsAccount(2)); accts.get(2).deposit(50); 
      return accts;
   }

   private static SavingsAccount findMax(ArrayList<SavingsAccount> a) {
      SavingsAccount max = a.get(0);
      for (int i=1; i<a.size(); i++) {
         if (a.get(i).compareTo(max) > 0)
            max = a.get(i);
      }
      return max;
   }
}

