package javaprogramdesign.chapter03.thread;

import java.util.Scanner;

public class ReadLine extends Thread {
   private boolean done = false;

   public void run() {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      sc.close();
      done = true;
   }

   public boolean isDone() {
      return done;
   }
}

