package javaprogramdesign.chapter04.intprocessor;

public class IntProcessorStrategy {
   private Operation op;

   public IntProcessorStrategy(Operation s) {
      this.op = s;
   }   
   public void operateOn(int x) {
      int y = f(x);
      System.out.println(x + " becomes " + y);
   }   
   private int f(int x) {
      return op.f(x);
   }
}

interface Operation {
   public int f(int x);
}

class AddOneStrategy implements Operation {
   public int f(int x) {
      return x+1;
   }
}

class AddTwoStrategy implements Operation {
   public int f(int x) {
      return x+2;
   }
}
