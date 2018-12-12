package javaprogramdesign.chapter04.comparator;

import java.util.*;
import javaprogramdesign.chapter04.bank10.*;

public class ComparatorBankAccounts {
   public static void main(String[] args) {
      List<BankAccount> accts = initAccts();

      Comparator<BankAccount> minbal = new AcctByMinBal();
      Comparator<BankAccount> maxbal = innerClassComp();
      Comparator<BankAccount> minnum = lambdaExpComp1();
      Comparator<BankAccount> maxnum = lambdaExpComp2();

      BankAccount a1 = findMax(accts, minbal);
      BankAccount a2 = findMax(accts, maxbal);
      BankAccount a3 = Collections.max(accts, minnum);
      BankAccount a4 = Collections.max(accts, maxnum);

      System.out.println("Acct with smallest balance is " + a1);
      System.out.println("Acct with largest balance is "  + a2);
      System.out.println("Acct with smallest number is "  + a3);     
      System.out.println("Acct with largest number is "   + a4);     
   }

   private static List<BankAccount> initAccts() {
      List<BankAccount> accts = new ArrayList<>();
      accts.add(new SavingsAccount(0));  accts.get(0).deposit(100); 
      accts.add(new RegularChecking(1)); accts.get(1).deposit(200); 
      accts.add(new SavingsAccount(2));  accts.get(2).deposit(50); 
      return accts;
   }

   private static Comparator<BankAccount> innerClassComp() {
      Comparator<BankAccount> result = new Comparator<BankAccount>() {
         public int compare(BankAccount ba1, BankAccount ba2) {
            int bal1 = ba1.getBalance();
            int bal2 = ba2.getBalance();
            if (bal1 == bal2)
               return ba1.getAcctNum() - ba2.getAcctNum();
            else
               return bal1 - bal2;
         }
      };
      return result;
   }

   private static Comparator<BankAccount> lambdaExpComp1() {
      Comparator<BankAccount> result = (BankAccount ba1, BankAccount ba2) -> {
         return ba2.getAcctNum() - ba1.getAcctNum(); 
      };
      return result;
   }

   private static Comparator<BankAccount> lambdaExpComp2() {
      Comparator<BankAccount> result = 
            (ba1, ba2) -> ba1.getAcctNum() - ba2.getAcctNum();
            return result;
   } 

   private static BankAccount findMax(List<BankAccount> a, Comparator<BankAccount> cmp) {
      BankAccount max = a.get(0);
      for (int i=1; i<a.size(); i++) {
         if (cmp.compare(a.get(i),max) > 0)
            max = a.get(i);
      }
      return max;
   }
}
