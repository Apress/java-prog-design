package javaprogramdesign.chapter08.bank17;

import java.util.function.Consumer;

public interface Visitor<T,R> extends Consumer<T> {
   R result();
}
