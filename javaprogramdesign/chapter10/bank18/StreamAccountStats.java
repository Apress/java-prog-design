package javaprogramdesign.chapter10.bank18;

import java.util.function.*;
import java.util.stream.Stream;

public class StreamAccountStats {
   private Bank bank;

   public StreamAccountStats(Bank b) {
      bank = b;
   }

   public void printAccounts6(Predicate<BankAccount> pred) {
      Stream<BankAccount> s = bank.stream();
      s = s.filter(pred);
      s.forEach(ba->System.out.println(ba));
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

