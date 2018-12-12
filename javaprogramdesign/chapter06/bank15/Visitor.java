package javaprogramdesign.chapter06.bank15;

import java.util.function.Consumer;

public interface Visitor<T,R> extends Consumer<T> {
   R result();
}
