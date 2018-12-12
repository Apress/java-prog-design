package javaprogramdesign.chapter01.bank02;

import java.util.*;

public class Bank {
   private HashMap<Integer,Integer> accounts = new HashMap<>();
   private double rate = 0.01;
   private int nextacct = 0;

   public int newAccount() {
      int acctnum = nextacct++;
      accounts.put(acctnum, 0);
      return acctnum;
   }

   public int getBalance(int acctnum) {
      return accounts.get(acctnum);
   }

   public void deposit(int acctnum, int amt) {
      int balance = accounts.get(acctnum);
      accounts.put(acctnum, balance+amt);
   }

   public boolean authorizeLoan(int acctnum, int loanamt) {
      int balance = accounts.get(acctnum);
      return balance >= loanamt / 2;
   }

   public String toString() {
      Set<Integer> accts = accounts.keySet();
      String result = "The bank has " + accts.size() + " accounts.";
      for (int i : accts)
         result += "\n\tAccount " + i + ": balance=" + accounts.get(i);
      return result;
   }

   public void addInterest() {
      Set<Integer> accts = accounts.keySet();
      for (int i : accts) {
         int balance = accounts.get(i);
         int newbalance = (int) (balance * (1 + rate));
         accounts.put(i, newbalance);
      }
   }
}
