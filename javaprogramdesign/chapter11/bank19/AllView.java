package javaprogramdesign.chapter11.bank19;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AllView {
   private Pane root;
   TextArea accts = new TextArea();

   public AllView(AllController controller) { 
      controller.setView(this);
      root = createNodeHierarchy(controller);
   }

   public Pane root() {
      return root;
   }

   public void setAccounts(String s) {
      accts.setText(s);
   }

   private Pane createNodeHierarchy(AllController controller) {
      accts.setPrefColumnCount(22);
      accts.setPrefRowCount(9);

      Button intbtn  = new Button("Add Interest");
      intbtn.setOnAction(e -> controller.interestButton());

      VBox p1 = new VBox(8);
      p1.setAlignment(Pos.TOP_CENTER);
      p1.setPadding(new Insets(10));
      Label title = new Label("Manage All Accounts");
      double size = title.getFont().getSize();
      title.setFont(new Font(size*2));
      title.setTextFill(Color.GREEN);
      p1.getChildren().addAll(title, accts, intbtn);
      return p1;
   }
}
