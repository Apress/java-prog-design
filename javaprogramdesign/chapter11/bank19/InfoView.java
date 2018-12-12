package javaprogramdesign.chapter11.bank19;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InfoView {
   private Pane root;
   private TextField balfld = createTextField(true);
   private ChoiceBox<String> forbx = new ChoiceBox<>();
   public InfoView(InfoController controller) {
      controller.setView(this);
      root = createNodeHierarchy(controller);
   }

   public Pane root() {
      return root;
   }

   public void setBalance(String s) {
      balfld.setText(s);
   }

   public void setForeign(boolean b) {
      String s = b ? "Foreign" : "Domestic";
      forbx.setValue(s);
   }

   private Pane createNodeHierarchy(InfoController controller) {
      Label selectlbl = new Label("Account #");
      TextField selectfld = createTextField(false);
      Button selectbtn = new Button("Select Account");
      Node p6 = createHBox(selectlbl, selectfld, selectbtn);
      Label ballbl = new Label("Balance:");
      Node p7 = createHBox(ballbl, balfld);
      Node p2 = createBorderedVBox(p6, p7);

      Label deplbl = new Label("Amt to Deposit");
      TextField depfld = createTextField(false);
      Button depbtn = new Button("Deposit");
      Node p8 = createHBox(deplbl, depfld, depbtn);      
      Node p3 = createBorderedVBox(p8);

      Label  loanlbl = new Label("Loan Amt");
      TextField loanfld = createTextField(false);
      Button loanbtn = new Button("Approve Loan");
      Node p9 = createHBox(loanlbl, loanfld, loanbtn);

      Label resplbl = new Label("Approval Status: ");
      TextField respfld = createTextField(true);
      Node p10 = createHBox(resplbl, respfld);
      Node p4 = createBorderedVBox(p9,p10);

      Label forlbl = new Label("Ownership");
      forbx.getItems().addAll("Foreign", "Domestic");
      Button forbtn = new Button("Set Ownership");
      Node p11 = createHBox(forlbl, forbx, forbtn);
      Node p5 = createBorderedVBox(p11);

      VBox p1 = new VBox(8);
      p1.setAlignment(Pos.TOP_CENTER);
      p1.setPadding(new Insets(10));
      Label title = new Label("Access an Existing Account");
      double size = title.getFont().getSize();
      title.setFont(new Font(size*2));
      title.setTextFill(Color.GREEN);
      p1.getChildren().addAll(title, p2, p3, p4, p5);

      depbtn.setOnAction   (e -> controller.depositButton(depfld.getText()));
      loanbtn.setOnAction  (e -> respfld.setText(controller.loanButton(loanfld.getText())));
      forbtn.setOnAction   (e -> controller.foreignButton(forbx.getValue()));
      selectbtn.setOnAction(e -> controller.selectButton(selectfld.getText()));

      return p1;
   }

   private Node createBorderedVBox(Node... children) {
      VBox vb = new VBox(4);
      vb.setPadding(new Insets(8));
      BorderStroke bs = new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, null, null, new Insets(10));
      vb.setBorder(new Border(bs));
      vb.getChildren().addAll(children);
      return vb;      
   }

   private Node createHBox(Node... children) {
      HBox hb = new HBox(5);
      hb.setAlignment(Pos.CENTER_LEFT);
      hb.getChildren().addAll(children);
      hb.setPadding(new Insets(2));
      return hb;      
   }

   private TextField createTextField(boolean b) {
      TextField result = new TextField();
      result.setPrefWidth(85);
      result.setDisable(b);
      return result;
   }
}
