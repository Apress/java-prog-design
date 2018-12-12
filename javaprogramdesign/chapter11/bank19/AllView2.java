package javaprogramdesign.chapter11.bank19;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AllView2 {
   private Pane root;
   ListView<BankAccount> accts = new ListView<>();

   public AllView2(AllController2 controller) { 
      root = createNodeHierarchy(controller);
      accts.setItems(controller.getAccountList());
      accts.setPrefSize(300, 200);
   }

   public Pane root() {
      return root;
   }

   private Pane createNodeHierarchy(AllController2 cont) {
      Button intbtn  = new Button("Add Interest");
      intbtn.setOnAction(e -> cont.interestButton());

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
