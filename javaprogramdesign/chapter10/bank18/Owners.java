package javaprogramdesign.chapter10.bank18;

public enum Owners implements OwnerStrategy {
   DOMESTIC(false,0,"domestic"), FOREIGN(true,500,"foreign");

   private boolean isforeign;
   private int fee;
   private String location;

   private Owners(boolean isforeign, int fee, String location) {
      this.isforeign = isforeign;
      this.fee = fee;
      this.location = location;
   }

   public boolean isForeign() {
      return isforeign;
   }

   public int fee() {
      return fee;
   }

   public String location() {
      return location;
   }
}
