package javaprogramdesign.chapter09.predicate;

import java.util.function.Predicate;

public abstract class CompositePredicate<T> implements Predicate<T> {
   protected Predicate<T> p1, p2;

   protected CompositePredicate(Predicate<T> p1, Predicate<T> p2) {
      this.p1 = p1;
      this.p2 = p2;
   }

   public abstract boolean test(T t);
}
