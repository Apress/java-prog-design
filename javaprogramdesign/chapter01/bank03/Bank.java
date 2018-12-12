package javaprogramdesign.chapter01.bank03;

import java.util.*;

public class Bank {
   private HashMap<Integer,BankAccount> accounts = new HashMap<>();
   private double rate = 0.01;
   private int nextacct = 0;

   public int newAccount(boolean isforeign) {
      int acctnum = nextacct++;
      BankAccount ba = new BankAccount(acctnum);
      ba.setForeign(isforeign);
      accounts.put(acctnum, ba);
      return acctnum;
   }

   public int getBalance(int acctnum) {
      BankAccount ba = accounts.get(acctnum);
      return ba.getBalance();
   }

   public void deposit(int acctnum, int amt) {
      BankAccount ba = accounts.get(acctnum);
      int balance = ba.getBalance();
      ba.setBalance(balance+amt);
   }

   public void setForeign(int acctnum, boolean isforeign) {
      BankAccount ba = accounts.get(acctnum);
      ba.setForeign(isforeign);
   }

   public boolean authorizeLoan(int acctnum, int loanamt) {
      BankAccount ba = accounts.get(acctnum);
      int balance = ba.getBalance();
      return balance >= loanamt / 2;
   }

   public String toString() {
      String result = "The bank has " + accounts.size() + " accounts.";
      for (BankAccount ba : accounts.values()) 
         result += "\n\tAccount " + ba.getAcctNum() + ": balance=" 
               + ba.getBalance() + ", is "
               + (ba.isForeign() ? "foreign" : "domestic");
      return result;
   }

   public void addInterest() {
      for (BankAccount ba : accounts.values()) {
         int balance = ba.getBalance();
         balance += (int) (balance * rate);
         ba.setBalance(balance);
      }
   }
}
