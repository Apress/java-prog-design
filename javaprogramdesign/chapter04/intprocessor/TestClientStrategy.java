package javaprogramdesign.chapter04.intprocessor;

public class TestClientStrategy {
   public static void main(String[] args) {
      Operation op1 = new AddOneStrategy();
      Operation op2 = new AddTwoStrategy();
      IntProcessorStrategy p1 = new IntProcessorStrategy(op1);
      IntProcessorStrategy p2 = new IntProcessorStrategy(op2);
      p1.operateOn(6); p2.operateOn(6);
   }
}
