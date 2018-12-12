package javaprogramdesign.chapter06.iteration;

import java.util.*;

public class NoDuplicates {

   public static boolean noDuplicates(List<String> L) {
      Iterator<String> iter = L.iterator();
      while (iter.hasNext()) {
         String s = iter.next();
         if (!isUnique(L, s))
            return false;
      }
      return true;
   }

   private static boolean isUnique(List<String> L, String s) {
      int count = 0;
      Iterator<String> iter = L.iterator();
      while (iter.hasNext()) 
         if (iter.next().equals(s))
            count++;
      return count == 1;
   }

   public static void main(String[] args) {
      List<String> L = Arrays.asList("a", "b", "c", "b", "e");
      boolean b = noDuplicates(L);
      System.out.println(b);
   }
}
