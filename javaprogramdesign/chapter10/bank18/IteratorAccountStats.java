package javaprogramdesign.chapter10.bank18;

import java.util.*;
import java.util.function.*;

public class IteratorAccountStats {
   private Bank bank;

   public IteratorAccountStats(Bank b) {
      bank = b;
   }

   public void printAccounts1() {
      Iterator<BankAccount> iter = bank.iterator();
      while (iter.hasNext()) {
         BankAccount ba = iter.next();
         System.out.println(ba);
      }
   }

   public int maxBalance1() {
      Iterator<BankAccount> iter = bank.iterator();
      int max = 0;
      while (iter.hasNext()) {
         BankAccount ba = iter.next();
         int balance = ba.getBalance();
         if (balance > max) 
            max = balance;
      }
      return max;
   }

   public void printAccounts2() {
      for (BankAccount ba : bank)
         System.out.println(ba);
   }

   public int maxBalance2() {
      int max = 0;
      for (BankAccount ba : bank) {
         int balance = ba.getBalance();
         if (balance > max) 
            max = balance;
      }
      return max;
   }

   public void printAccounts3() {
      Consumer<BankAccount> action = ba -> System.out.println(ba);
      bank.forEach(action);
   }

   public int maxBalance3a() {
      Visitor<BankAccount,Integer> r = new MaxBalanceVisitor();
      bank.forEach(r);
      return r.result();
   }

   public int maxBalance3b() {
      Visitor<BankAccount,Integer> v = 
            new Visitor<BankAccount,Integer>() {
         private int max = 0;
         public void accept(BankAccount ba) {
            int bal = ba.getBalance();
            if (bal > max)
               max = bal;
         }
         public Integer result() {
            return max;
         }
      };
      bank.forEach(v);
      return v.result();
   }

   public void visit1(Consumer<BankAccount> action) {
      bank.forEach(action);
   }

   public <R> R visit2(Visitor<BankAccount,R> action) {
      bank.forEach(action);
      return action.result();
   }

   public int maxBalance3c() {
      return visit2(new MaxBalanceVisitor());
   }   

   public void printAccounts4(Predicate<BankAccount> pred) {
      for (BankAccount ba : bank)
         if (pred.test(ba)) 
            System.out.println(ba);
   }

   public int maxBalance4(Predicate<BankAccount> pred) {
      int max = 0;
      for (BankAccount ba : bank) {
         if (pred.test(ba)) {
            int balance = ba.getBalance();
            if (balance > max) 
               max = balance;
         }
      }
      return max;
   }

   public void printAccounts5(Predicate<BankAccount> pred) {
      Consumer<BankAccount> action = ba -> {if (pred.test(ba)) System.out.println(ba);};
      bank.forEach(action);
   }

   public int maxBalance5(Predicate<BankAccount> pred) {
      Visitor<BankAccount,Integer> r = new MaxBalanceVisitor();
      Consumer<BankAccount> action = ba -> {if (pred.test(ba)) r.accept(ba);};
      bank.forEach(action);
      return r.result();
   }

   public void visit3(Predicate<BankAccount> pred, Consumer<BankAccount> action) {
      bank.forEach(ba -> {if (pred.test(ba)) action.accept(ba);});
   }

   public <R> R visit4(Predicate<BankAccount> pred, Visitor<BankAccount, R> action) {
      bank.forEach(ba -> {if (pred.test(ba)) action.accept(ba);});
      return action.result();
   }
}

