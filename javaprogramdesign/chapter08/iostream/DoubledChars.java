package javaprogramdesign.chapter08.iostream;

import java.io.*;

public class DoubledChars {
   public static final int N = 1;

   public static void main(String[] args) throws IOException {
      try (Reader r = new FileReader("mobydick.txt");
           Reader br = new BufferedReader(r)) {
         int x = br.read();  // For each char,
         while (x >= 0) {
            char c = (char) x;
            check(br, c);    // check the N+1st char after it.
            x = br.read();
         }
      }
   }

   private static void check(Reader r, char c) throws IOException {
      char[] a = new char[N+1];
      r.mark(N+1);
      int howmany = r.read(a); 
      if (howmany == N+1 && a[N] == c) {
         System.out.print(c); System.out.println(a);
      }
      r.reset();
   }
}
