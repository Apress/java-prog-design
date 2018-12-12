package javaprogramdesign.chapter06.iteration;

import java.util.*;

public class PrimeCollection extends AbstractCollection<Integer> {
   private int size;

   public PrimeCollection(int size) {
      this.size = size;
   }

   public int size() {
      return size;
   }

   public Iterator<Integer> iterator() {
      return new PrimeIterator(size);
   }

   public static void main(String[] args) {
      Collection<Integer> c = new PrimeCollection(10);
      // print an iterator for c
      for (int i : c) 
         System.out.print(i + " ");
   }
}

