package javaprogramdesign.chapter08.iostream;

import java.io.*;
import javax.crypto.*;

public class DecoratedEncryptDecrypt {
   public static void main(String[] args) throws Exception {
      KeyGenerator kg = KeyGenerator.getInstance("DES");
      kg.init(56); // DES uses 56-bit keys
      SecretKey key = kg.generateKey();   

      encrypt("mobydick.txt",  "encrypted.txt", key, Cipher.ENCRYPT_MODE);
      encrypt("encrypted.txt", "decrypted.txt", key, Cipher.DECRYPT_MODE);
   }

   private static void encrypt(String source, String output, SecretKey key, int mode) throws Exception {
      Cipher c = Cipher.getInstance("DES");
      c.init(mode, key);
      try (InputStream  is = new FileInputStream(source);
           InputStream cis = new CipherInputStream(is, c);
           OutputStream os = new FileOutputStream(output)) {

         int x = cis.read();
         while (x >= 0) {
            byte b = (byte) x;
            os.write(b);
            x = cis.read();
         }
      }     
   }
}
