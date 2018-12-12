package javaprogramdesign.chapter08.bank17;

import java.util.Iterator;

public class UnmodifiableBankIterator implements Iterator<BankAccount> {
   private Iterator<BankAccount> iter;

   public UnmodifiableBankIterator(Iterator<BankAccount> iter) {
      this.iter = iter;
   }

   public boolean hasNext() {
      return iter.hasNext();
   }

   public BankAccount next() {
      return new UnmodifiableAccount(iter.next());
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}

