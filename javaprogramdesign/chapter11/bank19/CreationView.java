package javaprogramdesign.chapter11.bank19;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CreationView  {
   private Pane root;
   private Label title = new Label("Create a New Bank Account");

   public CreationView(CreationController controller) {
      controller.setView(this);
      root = createNodeHierarchy(controller);
   }

   public Pane root() {
      return root;
   }

   public void setTitle(String msg) {
      title.setText(msg);
   }

   private Pane createNodeHierarchy(CreationController cont) {
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
      p1.setAlignment(Pos.TOP_CENTER);
      p1.setPadding(new Insets(10));
      Label title = new Label("Create a New Bank Account");
      double size = title.getFont().getSize();
      title.setFont(new Font(size*2));
      title.setTextFill(Color.GREEN);
      p1.getChildren().addAll(title, p2);

      title.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            e -> title.setTextFill(Color.GREEN));
      title.addEventHandler(MouseEvent.MOUSE_EXITED,  
            e -> title.setTextFill(Color.GREEN));

      p1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
         ckbx.setSelected(false);
         chbx.setValue(null);
         title.setText("Create a New Bank Account");
      });

      btn.addEventHandler(ActionEvent.ACTION, e -> {
         cont.buttonPressed(chbx.getSelectionModel().getSelectedIndex(), 
               ckbx.isSelected());
         String foreign = ckbx.isSelected() ? "Foreign " : "";
         String acct = chbx.getValue();
         title.setText(foreign + acct + " Account Created");
      });

      ObservableValue<String> obsval = chbx.valueProperty();
      ChangeListener<String> listener = 
            (obj, oldval, newval) -> btn.setDisable(newval==null);
            obsval.addListener(listener);

            return p1;
   }
}







