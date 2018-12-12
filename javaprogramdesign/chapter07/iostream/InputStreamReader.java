package javaprogramdesign.chapter07.iostream;

import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class InputStreamReader extends Reader {
   public static int BUFF_SIZE = 3;
   private ByteBuffer bb = ByteBuffer.allocate(BUFF_SIZE);
   private InputStream is;
   private CharsetDecoder decoder; 
   private boolean noMoreInput;

   public InputStreamReader(InputStream is, String charsetname) throws IOException {
      this.is = is;
      decoder = Charset.forName(charsetname).newDecoder();
      bb.position(bb.limit());
      noMoreInput = fillByteBuffer();
   }

   public InputStreamReader(InputStream is) throws IOException {
      this(is, Charset.defaultCharset().name());
   }

   public int read(char cbuf[], int offset, int len) throws IOException {
      int howmany = len;
      while (true) {
         CharBuffer cb = CharBuffer.wrap(cbuf, offset, len);
         CoderResult result = decoder.decode(bb, cb, noMoreInput);
         if (result == CoderResult.OVERFLOW)
            return howmany;
         else if (result == CoderResult.UNDERFLOW && noMoreInput)
            return (cb.position() > 0) ? cb.position() : -1;
         else if (result == CoderResult.UNDERFLOW) {   
            // Get more bytes and repeat the loop.
            noMoreInput = fillByteBuffer();
            offset = cb.position();
            len = howmany - cb.position();
         }
         else 
            result.throwException();
      }
   }

   public void close() throws IOException {
      is.close();
   }

   private boolean fillByteBuffer() throws IOException {
      bb.compact();
      int pos = bb.position();
      int amtToRead = bb.capacity() - pos;
      int result = is.read(bb.array(), pos, amtToRead);
      int amtActuallyRead = (result < 0) ? 0 : result;
      int newlimit = pos + amtActuallyRead;
      bb.limit(newlimit);
      bb.position(0);
      return (amtActuallyRead < amtToRead);
   }
   
   public static void main(String[] args) throws Exception {
      InputStream is = new FileInputStream("test16.out");
      Reader r = new InputStreamReader(is, "UTF-16");
      int size = 6;
      char[] a = new char[size];
      int x = r.read(a, 0, size);
      while (x>=0) {
         for (int i=0; i<x; i++) System.out.print((char)a[i]);
         System.out.println();
         x = r.read(a, 0, size);
      }
      System.out.println();
      r.close();
   }
}

