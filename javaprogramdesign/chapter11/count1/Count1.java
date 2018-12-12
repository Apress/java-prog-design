package javaprogramdesign.chapter11.count1;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Count1 extends Application {
   private static int count = 0;
   private static Label lbl = new Label("Count is 0");

   public void start(Stage stage) {
      Button inc = new Button("Increment");
      Button dec = new Button("Decrement");
      VBox p = new VBox(8);
      p.setAlignment(Pos.CENTER);
      p.setPadding(new Insets(10));
      p.getChildren().addAll(lbl, inc, dec);

      inc.setOnAction(e -> updateBy(1));
      dec.setOnAction(e -> updateBy(-1));

      stage.setScene(new Scene(p));
      stage.show();
   }

   private static void updateBy(int n) {
      count += n;
      lbl.setText("Count is " + count);
   }

   public static void main(String[] args) {
      Application.launch(args);
   }   
}
