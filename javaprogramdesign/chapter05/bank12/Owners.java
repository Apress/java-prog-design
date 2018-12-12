package javaprogramdesign.chapter05.bank12;

public enum Owners implements OwnerStrategy {
   DOMESTIC(false,0,"domestic"), FOREIGN(true,500,"foreign");

   private boolean isforeign;
   private int fee;
   private String name;

   private Owners(boolean isforeign, int fee, String name) {
      this.isforeign = isforeign;
      this.fee = fee;
      this.name = name;
   }

   public boolean isForeign() {
      return isforeign;
   }

   public int fee() {
      return fee;
   }

   public String toString() {
      return name;
   }
}
