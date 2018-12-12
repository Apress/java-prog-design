package javaprogramdesign.chapter07.bank16;

import java.io.Serializable;

public interface OwnerStrategy extends Serializable {
   boolean isForeign();
   String location();
   int fee();
}
