package javaprogramdesign.chapter11.count3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.*;

public class Count3 extends Application {
   public void start(Stage stage) {
      CountModel model = new CountModel();
      CountController ccontroller = new CountController(model);
      CountView cview = new CountView(ccontroller);
      WatcherController wcontroller = new WatcherController(model);
      WatcherView wview = new WatcherView(wcontroller);

      // Display the views in a single two-pane window.
      BorderStroke bs = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null, new Insets(10));
      Border b = new Border(bs);
      Pane root1 = cview.root(); 
      Pane root2 = wview.root();
      root1.setBorder(b); root2.setBorder(b);
      HBox p = new HBox();
      p.getChildren().addAll(root1, root2);
      stage.setScene(new Scene(p));
      stage.show();
   }

   public static void main(String[] args) {
      Application.launch(args);
   } 
}
