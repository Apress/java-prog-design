package javaprogramdesign.chapter11.count2;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;

public class Count2 extends Application {
   public void start(Stage stage) {
      CountModel model = new CountModel();
      CountController controller = new CountController(model);
      CountView view = new CountView(controller);

      Scene scene = new Scene(view.getRoot());
      stage.setScene(scene);
      stage.show();
   }

   public static void main(String[] args) {
      Application.launch(args);
   } 
}
