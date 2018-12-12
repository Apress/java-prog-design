package javaprogramdesign.chapter09.cookbook;

import java.util.*;

public class Recipe implements FoodItem {
   private String name;
   private Map<FoodItem,Integer> ingredients = new HashMap<>();
   private String directions;
   
   public Recipe(String name, String directions) {
      this.name = name;
      this.directions = directions;
   }
   
   public void addIngredient(FoodItem item, int qty) {
      ingredients.put(item, qty);
   }
   
   public String name() {
      return name;
   }
   
   public boolean isVegan() {
      Iterator<FoodItem> iter = childIterator();
      while (iter.hasNext())
         if (!iter.next().isVegan()) 
            return false;
      return true;
   }
   
   public Iterator<FoodItem> childIterator() {
      return ingredients.keySet().iterator();
   }
   
   public int getQuantity(FoodItem item) {
      return ingredients.get(item);
   }
   
   public String toString() {
      String veg = isVegan() ? " (vegan)" : "";
      String result = "*** Recipe for " + name + veg + " ***\n";
      result += "Ingredients:";
      for (FoodItem item : ingredients.keySet()) {
         int qty = ingredients.get(item);
         result += "\t" + qty + " " + item.name() + "\n";
      }
      return result + "Directions: " + directions + "\n";
   }
}
