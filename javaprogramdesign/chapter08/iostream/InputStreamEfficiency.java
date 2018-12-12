package javaprogramdesign.chapter08.iostream;

import java.io.*;

// Compare the efficiency of three ways to read an input stream.

public class InputStreamEfficiency {
   public static void main(String[] args) throws IOException {
      String src = "mobydick.txt";
      long t1 = readFileUnbuffered(src);
      long t2 = readFileArrayBuffer(src);
      long t3 = readFileDecoratorBuffer(src);
      System.out.println("Unbuffered time: " + t1);
      System.out.println("Array Buffer time: " + t2);
      System.out.println("Decorator Buffer time: " + t3);
   }

   public static long readFileUnbuffered(String src) throws IOException {
      long begintime = System.currentTimeMillis();
      try (InputStream is = new FileInputStream(src)) {
         int x = is.read();
         while (x >= 0) {
            byte b = (byte) x;
            // process b ...
            x = is.read();
         }
      } 
      return System.currentTimeMillis() - begintime;
   }

   public static long readFileArrayBuffer(String src) throws IOException {
      long begintime = System.currentTimeMillis();
      try (InputStream is = new FileInputStream(src)) {
         byte[] a = new byte[100];
         int howmany = is.read(a);
         while (howmany > 0) {
            for (int pos=0; pos<howmany; pos++) {
               byte b = a[pos];
               // process b ...
            }
            howmany = is.read(a);
         }
      } 
      return System.currentTimeMillis() - begintime;
   }

   public static long readFileDecoratorBuffer(String src) throws IOException {
      long begintime = System.currentTimeMillis();
      try (InputStream  is = new FileInputStream(src);
            InputStream bis = new BufferedInputStream(is)) {
         int x = bis.read();
         while (x >= 0) {
            byte b = (byte) x;
            // process b ...
            x = bis.read();
         }
      }  
      return System.currentTimeMillis() - begintime;
   }
}
