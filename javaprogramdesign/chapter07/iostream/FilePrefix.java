package javaprogramdesign.chapter07.iostream;

import java.io.*;

public class FilePrefix {
   public static void main(String[] args) throws IOException {
      try (Reader r = new FileReader("mobydick.txt");
           Writer w = new FileWriter("shortmoby.txt")) {
         for (int i=0; i<500; i++) {
            int x = r.read();
            if (x < 0)
               break;
            char c = (char) x;
            w.write(c);
         }
      }
   }
}
