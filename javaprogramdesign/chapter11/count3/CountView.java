package javaprogramdesign.chapter11.count3;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

class CountView {
   private Label lbl = new Label("Count is 0");
   private Pane root;

   public CountView(CountController controller) {
      root = createNodeHierarchy(controller);
      controller.setView(this);
   }

   public Pane root() {
      return root;
   }

   public void setLabel(String s) {
      lbl.setText(s);
   }

   private Pane createNodeHierarchy(CountController cont) {
      Button inc = new Button("Increment");
      Button dec = new Button("Decrement");

      VBox p = new VBox(8);
      p.setAlignment(Pos.CENTER);
      p.setPadding(new Insets(10));
      p.getChildren().addAll(lbl, inc, dec);

      inc.setOnAction(e -> cont.incrementButtonPressed());
      dec.setOnAction(e -> cont.decrementButtonPressed());

      return p;
   }
}