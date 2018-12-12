package javaprogramdesign.chapter07.iostream;

import java.io.*;
import java.util.*;

public class ObjectStreamTest {
   public static void main(String[] args) throws Exception {
      List<String>  L = Arrays.asList("a", "b", "c");

      // Write the list to a file, in two ways.
      try (OutputStream os  = new FileOutputStream("save.data");
           ObjectOutput oos = new ObjectOutputStream(os)) {

         oos.writeObject(L);  // write the list

         oos.writeInt(L.size()); // write the list size
         for (String s : L)      // and that many strings
            oos.writeObject(s);
      }

      // Read the lists from the file.
      try (InputStream is  = new FileInputStream("save.data");
           ObjectInput ois = new ObjectInputStream(is)) {

         List<String>  L1 = (List<String>)  ois.readObject(); // read the list

         List<String> L2 = new ArrayList<>();
         int size = ois.readInt();      // read the list size
         for (int i=0; i<size; i++) {   // read that many strings
            String s = (String) ois.readObject();
            L2.add(s);
         }
         // L, L1, and L2 are equivalent.
         System.out.println(L + ", " + L1 + ", " + L2);
      }
   }
}
