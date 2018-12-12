package javaprogramdesign.chapter03.bytestream;
import java.io.*;

public class EncryptDecrypt {
   public static void main(String[] args) throws IOException {
      int offset = 26;  // any value will do
      encrypt("mobydick.txt", "encrypted.txt", offset);
      encrypt("encrypted.txt", "decrypted.txt", -offset);
   }

   private static void encrypt(String source, String output, int offset) 
                               throws IOException {
      try ( InputStream  is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(output) ) {
         int x;
         while ((x = is.read()) >= 0) {
            byte b = (byte) x;
            b += offset;
            os.write(b);
         }
      }    
   }
}
