package javaprogramdesign.chapter11.count3;

class CountController implements CountObserver {
   private CountModel model;
   private CountView view;

   public CountController(CountModel model) {
      this.model = model;
      model.addObserver(this);
   }

   // Methods called by the view
   public void setView(CountView view) {
      this.view = view;
   }
   public void incrementButtonPressed() {
      model.updateBy(1);
   }
   public void decrementButtonPressed() {
      model.updateBy(-1);
   }

   // Method called by the model
   public void countUpdated(int count) {
      view.setLabel("Count is " + count);
   }
}






