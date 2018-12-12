package javaprogramdesign.chapter04.bank10;

public class Domestic implements OwnerStrategy {
   public boolean isForeign() {
      return false;
   }

   public int fee() {
      return 0;
   }

   public String toString() {
      return "domestic";
   }
}
