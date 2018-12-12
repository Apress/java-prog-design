package javaprogramdesign.chapter08.collectionstream;

import java.util.*;

public class SimpleStreamTest {
   public static void main(String[] args) {
      Collection<String> c = Arrays.asList("a", "bb", "ccc", "dddd");

      // Select the strings having length between 2 and 3, 
      // convert them to uppercase, and print them.
      
      new SimpleStream<String>(c.iterator())
            .filter(s->s.length() > 1)
            .filter(s->s.length() < 4)
            .map(s->s.toUpperCase())
            .forEach(s->System.out.println(s));
      
      // Select the strings having length between 2 and 3,
      // convert them to their length, find the max, and print it.
      
      Integer max = 
            new SimpleStream<String>(c.iterator())
                  .filter(s->s.length() > 1)
                  .filter(s->s.length() < 4)
                  .map(s->s.length())
                  .reduce(0, (i1,i2)->Math.max(i1, i2));
      System.out.println("The max length is " + max);
   }
}
