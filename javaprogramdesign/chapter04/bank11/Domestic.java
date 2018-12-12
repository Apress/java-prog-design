package javaprogramdesign.chapter04.bank11;

public class Domestic implements OwnerStrategy {
   public boolean isForeign() {
      return false;
   }

   public String toString() {
      return "domestic";
   }

   public int fee() {
      return 0;
   }
}
