package javaprogramdesign.chapter09.cookbook;

import java.util.*;

public class FoodIterator implements Iterator<FoodItem> {
   private Stack<Iterator<FoodItem>> s = new Stack<>();
   
   public FoodIterator(FoodItem f) {
      Collection<FoodItem> c = Collections.singleton(f);
      s.push(c.iterator());
   }
   
   public boolean hasNext() {
      return !s.isEmpty();
   }
   
   public FoodItem next() {
      FoodItem food = s.peek().next();
      if (!s.peek().hasNext())
         s.pop();
      Iterator<FoodItem> iter = food.childIterator();
      if (iter.hasNext())
         s.push(iter);
      return food;
   }
}

