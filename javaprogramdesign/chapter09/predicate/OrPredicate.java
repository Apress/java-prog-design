package javaprogramdesign.chapter09.predicate;

import java.util.function.Predicate;

public class OrPredicate<T> extends CompositePredicate<T> {
   public OrPredicate(Predicate<T> p1, Predicate<T> p2) {
      super(p1, p2);
   }

   public boolean test(T t) {
      return p1.test(t) || p2.test(t);
   }
}
