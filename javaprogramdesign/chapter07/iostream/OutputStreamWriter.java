package javaprogramdesign.chapter07.iostream;

import java.io.*;
import java.nio.*;
import java.nio.charset.*;

public class OutputStreamWriter extends Writer {
   private OutputStream os;
   private CharsetEncoder encoder;

   public OutputStreamWriter(OutputStream os, String charsetname) throws IOException {
      this.os = os;
      encoder = Charset.forName(charsetname).newEncoder();
   }

   public OutputStreamWriter(OutputStream os) throws IOException {
      this(os, Charset.defaultCharset().name());
   }

   public void write(char cbuf[], int offset, int len) throws IOException {
      CharBuffer cb = CharBuffer.wrap(cbuf, offset, len);
      ByteBuffer bb = encoder.encode(cb);
      for (int i=0; i<bb.limit(); i++) 
         os.write(bb.get(i));
   }

   public void close() throws IOException {
      os.close();
   }

   public void flush() throws IOException {
      os.flush();
   }

   public static void main(String[] args) throws Exception {
      OutputStream os = new FileOutputStream("test16.out");
      Writer w = new OutputStreamWriter(os, "UTF-16");
      char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
      for (char c : input) 
         w.write(c);
      w.flush();
      w.close();
   }
}

