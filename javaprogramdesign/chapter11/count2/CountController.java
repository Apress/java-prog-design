package javaprogramdesign.chapter11.count2;

class CountController {
   private CountModel model;

   public CountController(CountModel model) {
      this.model = model;
   }

   public String incrementButtonPressed() {
      model.updateBy(1);
      return "Count is " + model.getCount();
   }
   public String decrementButtonPressed() {
      model.updateBy(-1);
      return "Count is " + model.getCount();
   }
}

