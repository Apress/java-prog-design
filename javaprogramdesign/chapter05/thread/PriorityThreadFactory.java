package javaprogramdesign.chapter05.thread;
import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {

   private int priority;
   public PriorityThreadFactory(int p) {
      priority = p;
   }

   public Thread newThread(Runnable r) {
      Thread t = new Thread(r);
      t.setPriority(priority);
      return t;
   }

   public static void main(String[] args) {
      ThreadFactory important = new PriorityThreadFactory(9);
      ThreadFactory menial = new PriorityThreadFactory(1);
      Runnable r = ()->{};

      Thread t1 = important.newThread(r);
      Thread t2 = menial.newThread(r);
      System.out.println(t1.getPriority());
      System.out.println(t2.getPriority());
   }
}
