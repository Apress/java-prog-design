package javaprogramdesign.chapter10.fx;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.beans.binding.Binding;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AccountCreationWindow extends Application {
   public void start(Stage stage) {
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
      btn.setDisable(true);
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

      title.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new ColorLabelHandler(title, Color.RED));
      title.addEventHandler(MouseEvent.MOUSE_EXITED,  e -> title.setTextFill(Color.GREEN));

      p1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
         ckbx.setSelected(false);
         chbx.setValue(null);
         title.setText("Create a New Bank Account");
      });

      btn.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
         String foreign = ckbx.isSelected() ? "Foreign " : "";
         String acct = chbx.getValue();
         title.setText(foreign + acct + " Account Created");
         stage.sizeToScene();
      });

      // alternatively, use ActionEvent.ACTION:      
      // btn.addEventHandler(ActionEvent.ACTION, e -> {...});

      // alternatively, use the setOnAction method:
      // btn.setOnAction(e -> { ... });

      ChangeListener<Boolean> checkboxcolor = 
            (obj, oldval, newval) -> {
               Color c = newval ? Color.GREEN : Color.RED;
               ckbx.setTextFill(c);
            };
      Property<Boolean> p = ckbx.selectedProperty();
      p.addListener(checkboxcolor);

/*    // Alternatively, do everything in one statement:
      ckbx.selectedProperty().addListener(
            (obj, oldval, newval) -> {
               Color c = newval ? Color.GREEN : Color.RED;
               ckbx.setTextFill(c);
            });   
*/                    

      chbx.valueProperty().addListener(
          (obj, oldval, newval) -> btn.setDisable(newval==null));
      
/*    // Alternatively, use a binding:
      ObjectProperty<String> valprop = chbx.valueProperty();
      Binding<Boolean> nullvalbinding = valprop.isNull();
      nullvalbinding.addListener( 
            (obj, oldval, newval) -> btn.setDisable(nullvalbinding.getValue()));
*/
      
 /*   // Or even better, use the bind method:
      btn.disableProperty().bind(chbx.valueProperty().isNull());
*/
      
      stage.setScene(new Scene(p1));
      stage.setTitle("Bank Account Demo");
      stage.show();
   }

   public static void main(String[] args) {
      Application.launch(args);
   }
}

class ColorLabelHandler implements EventHandler<Event> {
   private Label lbl;
   private Color color;

   public ColorLabelHandler(Label lbl, Color color) {
      this.lbl = lbl;
      this.color = color;
   }

   public void handle(Event e) {
      lbl.setTextFill(color);
   }
}

