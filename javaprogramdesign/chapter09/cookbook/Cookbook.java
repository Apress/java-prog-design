package javaprogramdesign.chapter09.cookbook;

import java.util.*;
import java.util.function.Predicate;

public class Cookbook {
   private static Map<String,Recipe> cookbook = new HashMap<>();

   public static void main(String[] args) {
      addRecipes();
      System.out.println("\n---VEGAN RECIPES---"); 
      printRecipes(r->r.isVegan());
      System.out.println("\n---RECIPES USING 4+ ITEMS---"); 
      printRecipes(r -> foodsUsed1(r)>=4);
      System.out.println("\n---RECIPES USING 4+ ITEMS---"); 
      printRecipes(r -> foodsUsed2(r)>=4);
      System.out.println("\n---RECIPES USING 4+ ITEMS---"); 
      printRecipes(r -> foodsUsed3(r)>=4);
      System.out.println("\n---RECIPES COMPRISING SALAD---"); 
      printRecipesUsedIn1(cookbook.get("salad"));
      System.out.println("\n---RECIPES COMPRISING SALAD---"); 
      printRecipesUsedIn2(cookbook.get("salad"));
      System.out.println("\n---SHOPPING LIST FOR SALAD---"); 
      printShoppingList(cookbook.get("salad"), 2);
   }

   private static void addRecipes() {
      Recipe dressing = new Recipe("dressing", "Mix thoroughly.");
      dressing.addIngredient(new BasicFood("oil", true), 4);
      dressing.addIngredient(new BasicFood("vinegar", true), 2);
      cookbook.put("dressing", dressing);

      Recipe salad = new Recipe("salad", "Chop lettuce, add bacon. Pour dressing over it.");
      salad.addIngredient(new BasicFood("lettuce", true), 1);
      salad.addIngredient(new BasicFood("bacon", false), 6);
      salad.addIngredient(dressing, 1);
      cookbook.put("salad", salad);
   }

   private static void printRecipes(Predicate<FoodItem> pred) {
      for (Recipe r : cookbook.values())
         if (pred.test(r))
            System.out.println(r);
   }

   private static int foodsUsed1(FoodItem r) {
      int count = 0;
      if (r instanceof BasicFood) 
         count = 1;
      else {
         Iterator<FoodItem> iter = r.childIterator();
         while (iter.hasNext()) 
            count += foodsUsed1(iter.next());
      }
      return count;
   }

   private static int foodsUsed2(FoodItem r) {
      int count = 0;
      Iterator<FoodItem> iter = r.iterator();
      while (iter.hasNext()) 
         if (iter.next() instanceof BasicFood) 
            count++;
      return count;
   }

   private static int foodsUsed3(FoodItem r) {
      int count = 0;
      for (FoodItem item : r)
         if (item instanceof BasicFood) 
            count++;
      return count;
   }

   private static void printRecipesUsedIn1(Recipe r) {
      for (FoodItem item : r) {
         if (item instanceof Recipe) 
            System.out.println(item.name());
      }
   }

   private static void printRecipesUsedIn2(Recipe r) {
      r.forEach(item -> {
         if (item instanceof Recipe) {
            System.out.println(item.name());
         }});
   }

   private static void printShoppingList(Recipe r, int howmany) {
      Iterator<FoodItem> iter = r.childIterator();
      while (iter.hasNext()) {
         FoodItem item = iter.next();
         int amt = r.getQuantity(item) * howmany;
         if (item instanceof BasicFood)
            System.out.println(item.name() + " " + amt);
         else 
            printShoppingList((Recipe) item, amt);
      }
   }
}

