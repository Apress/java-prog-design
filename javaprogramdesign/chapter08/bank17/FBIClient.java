package javaprogramdesign.chapter08.bank17;

import java.util.*;

public class FBIClient {
   public static void main(String[] args) {
      Bank b = getBank();

      // put account info into a single list
      List<FBIAcctInfo> L = new ArrayList<>();
      for (BankAccount ba : b) 
         L.add(new BankAccountAdapter(ba));
      for (Loan ln : b.loans())  
         L.add(new LoanAdapter(ln));

      // then process the list
      int count = 0;
      for (FBIAcctInfo a : L) 
         if (a.isForeign() && a.balance() > 1000.0)
            count++;    
      System.out.println("The count is " + count);
   }

   private static Bank getBank() {
      SavedBankInfo info = new SavedBankInfo("bank17.info");
      Map<Integer,BankAccount> accounts = info.getAccounts();
      int nextacct = info.nextAcctNum();
      return new Bank(accounts, nextacct);
   }
}
