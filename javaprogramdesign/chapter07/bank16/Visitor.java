package javaprogramdesign.chapter07.bank16;

import java.util.function.Consumer;

public interface Visitor<T,R> extends Consumer<T> {
   R result();
}
