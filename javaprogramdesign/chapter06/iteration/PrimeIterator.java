package javaprogramdesign.chapter06.iteration;
import java.util.*;

public class PrimeIterator implements Iterator<Integer> {
   private int current = 1;
   private int total;
   private int count = 0;
   
   public PrimeIterator(int total) {
      this.total = total;
   }
   
   public boolean hasNext() {
      return count < total;
   }

   public Integer next() {
      current++;
      while (!isPrime(current)) 
         current++;
      count++;
      return current;
   }
   
   private boolean isPrime(int n) {
      for (int i=2; i*i<=n; i++)
         if (n%i == 0)
            return false;
      return true;
   }
   
   public static void main(String[] args) {
      Iterator<Integer> iter = new PrimeIterator(100);
      for (int i=0; i<100; i++)
         System.out.println(iter.next());
   }
}
