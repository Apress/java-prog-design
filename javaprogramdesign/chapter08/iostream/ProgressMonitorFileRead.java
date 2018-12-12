package javaprogramdesign.chapter08.iostream;

import java.io.*;
import javax.swing.ProgressMonitorInputStream;

public class ProgressMonitorFileRead {
   public static void main(String[] args) throws IOException {
      String src = "mobydick.txt";
      try (InputStream  is = new FileInputStream("mobydick.txt");
            InputStream pmis = new ProgressMonitorInputStream(null, "reading " + src, is)) {
         int x = pmis.read();
         while (x >= 0) {
            byte b = (byte) x;
            // process b ...
            x = pmis.read();
         }
      }
   }
}

