package javaprogramdesign.chapter11.count3;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

class WatcherView {
   private Label lbl = new Label("The count has not yet changed");
   private CheckBox iseven = new CheckBox("Value is now even");
   private CheckBox isodd = new CheckBox("Value is now odd");
   private Pane root;

   public WatcherView(WatcherController controller) {
      root = createNodeHierarchy();
      controller.setView(this);
   }

   public Pane root() {
      return root;
   }

   public void update(String s, boolean even, boolean odd) {
      lbl.setText(s);
      iseven.setSelected(even);
      isodd.setSelected(odd);
   }

   private Pane createNodeHierarchy() {
      iseven.setSelected(true);
      isodd.setSelected(false);

      VBox p = new VBox(8);
      p.setAlignment(Pos.CENTER);
      p.setPadding(new Insets(10));
      p.getChildren().addAll(lbl, iseven, isodd);

      return p;
   }
}
