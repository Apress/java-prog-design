package javaprogramdesign.chapter11.bank19;

import java.util.function.Consumer;

public interface Visitor<T,R> extends Consumer<T> {
   R result();
}
