package javaprogramdesign.chapter11.bank19;

import java.util.function.*;
import java.util.stream.Stream;

public class StreamStatModel {
   private Bank bank;

   public StreamStatModel(Bank b) {
      bank = b;
   }

   public String getAccounts6(Predicate<BankAccount> pred) {
      Stream<BankAccount> s = bank.stream();
      s = s.filter(pred);
      Stream<String> t = s.map(ba->ba.toString());
      return t.reduce("", (s1,s2)-> s1+s2+"\n");
   }

   public String getAccounts7(Predicate<BankAccount> pred) {
      return bank.stream()
                .filter(pred)
                .map(ba->ba.toString())
                .reduce("", (s1,s2)-> s1+s2+"\n");
   }

   public int maxBalance6(Predicate<BankAccount> pred) {
      return bank.stream()
                 .filter(pred)
                 .map(ba->ba.getBalance())
                 .reduce(0, (x,y)->Math.max(x,y));
   }
}

