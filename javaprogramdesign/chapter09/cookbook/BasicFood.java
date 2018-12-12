package javaprogramdesign.chapter09.cookbook;

import java.util.*;

public class BasicFood implements FoodItem {
   private String name;
   private boolean isvegan;
   
   public BasicFood(String name, boolean isvegan) {
      this.name = name;
      this.isvegan = isvegan;
   }
   
   public String name() {
      return name;
   }
   
   public boolean isVegan() {
      return isvegan;
   }
   
   public Iterator<FoodItem> childIterator() {
      return Collections.emptyIterator();
   }
   
   public String toString() {
      String veg = isvegan ? " (vegan)" : "";
      return name + veg;
   }
}
