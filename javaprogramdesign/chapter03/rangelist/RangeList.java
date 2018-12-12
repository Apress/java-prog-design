package javaprogramdesign.chapter03.rangelist;

import java.util.*;

public class RangeList extends AbstractList<Integer> {
   private int limit;

   public RangeList(int limit) {
      this.limit = limit;
   }

   public int size() {
      return limit;
   }

   public Integer get(int n) {
      return n;
   }

   public static void main(String[] args) {
      List<Integer> L = new RangeList(20);

      // print the list using get()
      for (int i=0; i<L.size(); i++)
         System.out.print(L.get(i) + " ");
      System.out.println();

      // print the list using its iterator
      for (int x : L)
         System.out.print(x + " ");
      System.out.println();
   }
}
