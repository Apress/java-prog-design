package javaprogramdesign.chapter08.collectionstream;

import java.util.Iterator;
import java.util.function.Function;

public class MapIterator<T,R> implements Iterator<R> {
   private Iterator<T> iter;
   private Function<T,R> f;

   public MapIterator(Iterator<T> iter, Function<T,R> f) {
      this.iter = iter;
      this.f = f;
   }

   public boolean hasNext() {
      return iter.hasNext();
   }

   public R next() {
      T t = iter.next();
      return f.apply(t);
   }
}

