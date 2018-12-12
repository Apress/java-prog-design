package javaprogramdesign.chapter03.rangelist;

import java.util.List;

public class RangeListTest {
   public static void main(String[] args) {
      List<Integer> L = new RangeList(20);
      for (int x : L)
         System.out.print(x + " ");
      System.out.println();
   }
}
