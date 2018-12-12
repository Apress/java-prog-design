package javaprogramdesign.chapter08.collectionstream;

import java.util.function.*;
import java.util.*;

public class SimpleStream<T> {
   Iterator<T> iter;

   public SimpleStream(Iterator<T> iter) {
      this.iter = iter;
   } 

   public Iterator<T> iterator() {
      return iter;
   }

   public SimpleStream<T> filter(Predicate<T> pred) {
      Iterator<T> newiter = new FilterIterator<T>(iter, pred);
      return new SimpleStream<T>(newiter);
   }

   public <R> SimpleStream<R> map(Function<T,R> f) {
      Iterator<R> newiter = new MapIterator<T,R>(iter, f);
      return new SimpleStream<R>(newiter);
   }

   public void forEach(Consumer<T> cons) {
      while (iter.hasNext()) {
         T t = iter.next();
         cons.accept(t);
      }
   }

   public T reduce(T identity, BinaryOperator<T> f) {
      T result = identity;
      while (iter.hasNext()) {
         T t = iter.next();
         result = f.apply(result, t);
      }
      return result;
   }
}
