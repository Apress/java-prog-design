package javaprogramdesign.chapter09.fx;

import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PrintNodeInformation extends Application {
   private Label label; 
   private ChoiceBox<String> chbx; 
   private Button btn; 
   private Pane p1, p2;

   public void start(Stage stage) {
      createNodeHierarchy();
      stage.setScene(new Scene(p1));
      stage.setTitle("Bank Account Demo");
      stage.show();
      System.out.println("NODE\tWID HT");
      printNodeSize(label);
      printNodeSize(chbx);
      printNodeSize(p2);
      printNodeSize(btn);
      printNodeSize(p1);
   }

   public static void main(String[] args) {
      Application.launch(args);
   }

   private void printNodeSize(Node n) {
      Bounds b = n.getLayoutBounds();  
      int w = (int) b.getWidth();
      int h = (int) b.getHeight();
      System.out.println(n.getId() + "\t" + w + " " + h );
   }

   private void createNodeHierarchy() {
      p2 = new VBox(10);
      p2.setId("p2");
      label = new Label("Select Account Type:");
      label.setId("label");
      chbx = new ChoiceBox<>();
      chbx.setId("chbox");
      chbx.getItems().addAll("Savings", "Checking", "Interest Checking");
      p2.getChildren().addAll(label, chbx);

      p1 = new HBox(10);
      p1.setId("p1");
      btn = new Button("CREATE ACCT");
      btn.setId("button");
      p1.setPadding(new Insets(10));
      p1.getChildren().addAll(p2, btn);
   }
}
