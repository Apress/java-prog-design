package javaprogramdesign.chapter03.bytestream;

import java.io.*;

// A simplified version of the class in the Java library.

public class ByteArrayInputStream extends InputStream {

   private byte[] a;
   private int pos = 0;

   public ByteArrayInputStream(byte[] a) {
      this.a = a;
   }

   public int read() throws IOException {
      if (pos >= a.length)
         return -1;
      else {
         pos++;
         return a[pos-1];
      }
   }
}

