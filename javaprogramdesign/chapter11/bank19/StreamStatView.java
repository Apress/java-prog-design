package javaprogramdesign.chapter11.bank19;

public class StreamStatView {
   StreamStatController c;

   public StreamStatView(StreamStatController c) {
      this.c = c;
   }

   public void run() {
      System.out.println("The max balance of the domestic accounts is " + c.maxBalance6());    
      System.out.println("Here are the domestic accounts.");
      System.out.println(c.getAccounts6());
      System.out.println("Here are the domestic accounts again.");
      System.out.println(c.getAccounts7());
   }
}
