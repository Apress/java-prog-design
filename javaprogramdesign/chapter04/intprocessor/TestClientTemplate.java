package javaprogramdesign.chapter04.intprocessor;

public class TestClientTemplate {
   public static void main(String[] args) {
      IntProcessorTemplate p1 = new AddOneTemplate();
      IntProcessorTemplate p2 = new AddTwoTemplate();
      p1.operateOn(6); p2.operateOn(6);
   }
}
