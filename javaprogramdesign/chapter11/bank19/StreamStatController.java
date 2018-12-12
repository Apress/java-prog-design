package javaprogramdesign.chapter11.bank19;

import java.util.function.*;

public class StreamStatController {
   private StreamStatModel model;
   Predicate<BankAccount> pred = ba -> ba.fee() == 0;      

   public StreamStatController (StreamStatModel model) {
      this.model = model;
   }

   public String getAccounts6() {
      return model.getAccounts6(pred);
   }

   public String getAccounts7() {
      return model.getAccounts7(pred);
   }

   public String maxBalance6() {
      return Integer.toString(model.maxBalance6(pred));
   }
}
