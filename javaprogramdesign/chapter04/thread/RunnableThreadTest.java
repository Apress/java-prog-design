package javaprogramdesign.chapter04.thread;

public class RunnableThreadTest {   
   public static void main(String[] args) {
      ReadLine r = new ReadLine();
      Thread t = new Thread(r);
      t.start();
      int i = 0;
      while(!r.isDone()) {
         System.out.println(i);
         i++;
      }
   }
}   

