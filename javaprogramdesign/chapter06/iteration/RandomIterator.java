package javaprogramdesign.chapter06.iteration;
import java.util.*;

public class RandomIterator implements Iterator<Integer> {
   private Random rand = new Random();

   public boolean hasNext() {
      return true;
   }

   public Integer next() {
      return rand.nextInt();
   }

   // Generate random numbers until a duplicate occurs.
   public static void main(String[] args) {
      Iterator<Integer> iter = new RandomIterator();
      Set<Integer> nums = new HashSet<>();
      boolean dupNotFound = true;
      while (dupNotFound) 
         dupNotFound = nums.add(iter.next());
      System.out.println(nums.size());
   }
}
