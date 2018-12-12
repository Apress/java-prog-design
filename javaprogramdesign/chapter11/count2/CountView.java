package javaprogramdesign.chapter11.count2;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

class CountView {
   private Pane root;

   public CountView(CountController cont) {
      root = createNodeHierarchy(cont);
   }

   public Pane getRoot() {
      return root;
   }

   private Pane createNodeHierarchy(CountController cont) {
      Button inc = new Button("Increment");
      Button dec = new Button("Decrement");
      Label  lbl = new Label("Count is 0");

      VBox p = new VBox(8);
      p.setAlignment(Pos.CENTER);
      p.setPadding(new Insets(10));
      p.getChildren().addAll(lbl, inc, dec);

      inc.setOnAction(e -> {
         String s = cont.incrementButtonPressed();
         lbl.setText(s);
      });
      dec.setOnAction(e -> lbl.setText(cont.decrementButtonPressed()));

      return p;
   }
}
