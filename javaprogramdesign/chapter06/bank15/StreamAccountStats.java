package javaprogramdesign.chapter06.bank15;

import java.util.function.*;
import java.util.stream.Stream;

public class StreamAccountStats {
   private Bank bank;

   public StreamAccountStats(Bank b) {
      bank = b;
   }

   public void printAccounts6(Predicate<BankAccount> pred) {
      Stream<BankAccount> s1 = bank.stream();
      Stream<BankAccount> s2 = s1.filter(pred);
      s2.forEach(ba->System.out.println(ba));
   }

   public void printAccounts7(Predicate<BankAccount> pred) {
      bank.stream()
          .filter(pred)
          .forEach(ba->System.out.println(ba));
   }

   public int maxBalance6(Predicate<BankAccount> pred) {
      return bank.stream()
                 .filter(pred)
                 .map(ba->ba.getBalance())
                 .reduce(0, (x,y)->Math.max(x,y));
   }
}

