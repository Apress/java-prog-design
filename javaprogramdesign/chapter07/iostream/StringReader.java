package javaprogramdesign.chapter07.iostream;

import java.io.*;

public class StringReader extends Reader {
   private String s;
   private int pos = 0;

   public StringReader(String s) throws IOException {
      this.s = s;
   }

   public int read(char[] cbuf, int off, int len)
         throws IOException {
      if (pos >= s.length())
         return -1;
      int count=0;
      while (count<len && pos<s.length()) {
         cbuf[off+count] = s.charAt(pos);
         pos++; count++;
      }
      return count;
   }

   public void close() { 
      // strings don't need to be closed
   }

   public static void main(String[] args) {
      try(Reader r = new StringReader("abcde")) {
      char[] a = new char[9];
      System.out.println(r.read(a));
      System.out.println(r.read(a));
      System.out.println(r.read(a));
      }
      catch(IOException ex){}
   }
}

