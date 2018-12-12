package javaprogramdesign.chapter11.bank19;

import java.io.Serializable;

public interface OwnerStrategy extends Serializable {
   boolean isForeign();
   String location();
   int fee();
}
