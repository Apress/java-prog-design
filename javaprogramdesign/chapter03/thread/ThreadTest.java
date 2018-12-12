package javaprogramdesign.chapter03.thread;

public class ThreadTest {   
   public static void main(String[] args) {
      ReadLine r = new ReadLine();
      r.start();
      int i = 0;
      while(!r.isDone()) {
         System.out.println(i);
         i++;
      }
   }
}   
