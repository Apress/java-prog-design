package javaprogramdesign.chapter09.cookbook;

import java.util.*;

public interface FoodItem extends Iterable<FoodItem> {
   String name();
   boolean isVegan();
   Iterator<FoodItem> childIterator();
   
   default Iterator<FoodItem> iterator() {
      return new FoodIterator(this);       
   }
}
