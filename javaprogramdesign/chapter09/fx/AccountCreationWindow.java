package javaprogramdesign.chapter09.fx;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AccountCreationWindow extends Application {
   public void start(Stage stage) {
      Pane root = createNodeHierarchy();
      stage.setScene(new Scene(root));
      stage.setTitle("Bank Account Demo");
      stage.show();      
   }

   public static void main(String[] args) {
      Application.launch(args);
   }

   private Pane createNodeHierarchy() {
      VBox p3 = new VBox(8);
      p3.setAlignment(Pos.CENTER); 
      p3.setPadding(new Insets(10));
      p3.setBackground(
            new Background(
                  new BackgroundFill(Color.SKYBLUE, 
                        new CornerRadii(20), new Insets(0))));
      Label type = new Label("Select Account Type:");
      ChoiceBox<String> chbx  = new ChoiceBox<>();
      chbx.getItems().addAll("Savings", "Checking", "Interest Checking");
      p3.getChildren().addAll(type, chbx);

      VBox p4 = new VBox(8);
      p4.setAlignment(Pos.CENTER);
      p4.setPadding(new Insets(10));
      CheckBox ckbx = new CheckBox("foreign owned?");
      Button btn  = new Button("CREATE ACCT");
      p4.getChildren().addAll(ckbx, btn); 

      HBox p2 = new HBox(8);
      p2.setAlignment(Pos.CENTER);
      p2.setPadding(new Insets(10));
      p2.getChildren().addAll(p3, p4);

      VBox p1 = new VBox(8);
      p1.setAlignment(Pos.CENTER);
      p1.setPadding(new Insets(10));
      Label title = new Label("Create a New Bank Account");
      double size = title.getFont().getSize();
      title.setFont(new Font(size*2));
      title.setTextFill(Color.GREEN);
      p1.getChildren().addAll(title, p2);
      btn.setOnAction(event -> {
         String foreign = ckbx.isSelected() ? "Foreign " : "";
         String acct = chbx.getValue();
         title.setText(foreign + acct + " Account Created");
      });
      return p1;
   }
}
