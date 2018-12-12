package javaprogramdesign.chapter09.predicate;

import java.util.function.Predicate;

// Three ways to create a composite predicate
public class CompositePredicateTest {
   public static void main(String[] args) {
      Predicate<Integer> p1 = n -> n < 20;
      Predicate<Integer> p2 = n -> n%2 == 0;
      Predicate<Integer> p3 = n -> n%3 == 0;

      // First: use AndPredicate and OrPredicate objects
      Predicate<Integer> p4 = new OrPredicate<Integer>(p2, p3);
      Predicate<Integer> p5 = new AndPredicate<Integer>(p1, p4);
      printUsing(p5);

      // Second: use the 'or' and 'and' methods individually
      Predicate<Integer> p6 = p2.or(p3);
      Predicate<Integer> p7 = p1.and(p6);
      printUsing(p7);

      // Third: compose the 'or' and 'and' methods
      Predicate<Integer> p8 = p1.and(p2.or(p3));
      printUsing(p8);
   }

   private static void printUsing(Predicate<Integer> p) {
      for (int i=1; i<100; i++) 
         if (p.test(i))
            System.out.print(i + " ");
      System.out.println();
   }
}
