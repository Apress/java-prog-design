package javaprogramdesign.chapter11.count3;

import java.util.*;

public class CountModel {
   private int count = 0;
   private Collection<CountObserver> observers = new ArrayList<>();

   public void addObserver(CountObserver obs) {
      observers.add(obs);
   }

   public void updateBy(int n) {
      count += n;
      notifyObservers(count);
   }

   public int getCount() {
      return count;
   }

   private void notifyObservers(int count) {
      for (CountObserver obs : observers)
         obs.countUpdated(count);
   }
}

