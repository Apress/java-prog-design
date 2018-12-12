package javaprogramdesign.chapter11.count2;

public class CountModel {
   private int count = 0;

   public void updateBy(int n) {
      count += n;
   }

   public int getCount() {
      return count;
   }
}

