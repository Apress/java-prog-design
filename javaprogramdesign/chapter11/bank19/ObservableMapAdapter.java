package javaprogramdesign.chapter11.bank19;

import java.util.*;
import javafx.collections.*;

public class ObservableMapAdapter extends ModifiableObservableListBase<BankAccount> {

   private final Map<Integer,BankAccount> delegate;

   public ObservableMapAdapter(Map<Integer,BankAccount> m) {
      delegate = m;
   }

   public BankAccount get(int index) {
      return delegate.get(index);
   }

   public int size() {
      return delegate.size();
   }

   protected void doAdd(int index, BankAccount element) {
      delegate.put(index, element);
   }

   protected BankAccount doSet(int index, BankAccount element) {
      return delegate.put(index, element);
   }

   protected BankAccount doRemove(int index) {
      return delegate.remove(index);
   }
}
