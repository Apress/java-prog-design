package javaprogramdesign.chapter11.bank19;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class FxBankProgram extends Application {
   private SavedBankInfo info = new SavedBankInfo("bank19.info");
   private Map<Integer,BankAccount> accounts = info.getAccounts();
   Bank bank = new Bank(accounts, info.nextAcctNum());
   private Pane root1, root2, root3;

   public void start(Stage stage) {      
      VBox left = new VBox();
      left.getChildren().addAll(root1, root2);
      HBox all = new HBox(left, root3);

      stage.setScene(new Scene(all));
      stage.show();
   }

   public void init() {
      Auditor aud = new Auditor(bank);
      bank.addObserver(BankEvent.DEPOSIT, 
            (event,ba,amt) -> {
               if (amt > 10000000)
                  bank.makeSuspicious(ba.getAcctNum());
            });

      CreationController c1 = new CreationController(bank);
      AllController2 c2 = new AllController2(bank);
      InfoController c3 = new InfoController(bank);
      CreationView v1 = new CreationView(c1);
      AllView3 v2 = new AllView3(c2);
      InfoView v3 = new InfoView(c3);

      BorderStroke bs = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null, new Insets(10));
      Border b = new Border(bs);
      root1 = v1.root(); root2 = v2.root(); root3 = v3.root();
      root1.setBorder(b); root2.setBorder(b); root3.setBorder(b);
   }

   public void stop() {
      info.saveMap(accounts, bank.nextAcctNum());      
   }

   public static void main(String[] args) {
      Application.launch(args);
   }
}

