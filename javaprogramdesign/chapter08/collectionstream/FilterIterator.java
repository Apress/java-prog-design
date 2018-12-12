package javaprogramdesign.chapter08.collectionstream;

import java.util.*;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {
   private Iterator<T> iter;
   private Predicate<T> pred;
   private T nextvalue;
   private boolean found = false;

   public FilterIterator(Iterator<T> iter, Predicate<T> pred) {
      this.iter = iter;
      this.pred = pred;
   }

   public boolean hasNext() {
      while (!found && iter.hasNext()) {
         T t = iter.next();
         if (pred.test(t)) {
            nextvalue = t;
            found = true;
         }
      }
      return found;
   }

   public T next() {
      hasNext();  // just to be safe
      if (!found)
         throw new NoSuchElementException();
      found = false;
      return nextvalue;
   }
}

