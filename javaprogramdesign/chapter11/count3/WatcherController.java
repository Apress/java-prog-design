package javaprogramdesign.chapter11.count3;

public class WatcherController implements CountObserver {
   private WatcherView view;
   private int howmany = 0;

   public WatcherController(CountModel model) {
      model.addObserver(this);
   }

   public void setView(WatcherView view) {
      this.view = view;
   }

   public void countUpdated(int count) {
      howmany++;
      boolean iseven = (count%2 == 0);
      boolean isodd = !iseven;
      String msg = "The count has changed " + howmany + " times";
      view.update(msg, iseven, isodd);
   }
}







