package javaprogramdesign.chapter10.bank18;

import java.util.function.Consumer;

public interface Visitor<T,R> extends Consumer<T> {
   R result();
}
