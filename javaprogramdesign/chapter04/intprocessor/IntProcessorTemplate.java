package javaprogramdesign.chapter04.intprocessor;

public abstract class IntProcessorTemplate {
   public void operateOn(int x) {
      int y = f(x);
      System.out.println(x + " becomes " + y);
   }   
   protected abstract int f(int x);
}

class AddOneTemplate extends IntProcessorTemplate {
   protected int f(int x) {
      return x+1;
   }
}

class AddTwoTemplate extends IntProcessorTemplate {
   protected int f(int x) {
      return x+2;
   }
}
