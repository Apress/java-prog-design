package javaprogramdesign.chapter11.bank19;

public enum AccountFactories implements AccountFactory {
   SAVINGS("Savings",
         acctnum -> new SavingsAccount(acctnum)),
   REGULAR_CHECKING("Regular checking",
         acctnum -> new RegularChecking(acctnum)),
   INTEREST_CHECKING("Interest checking",
         acctnum -> new InterestChecking(acctnum)),
   NEW_CUSTOMER("New Customer Savings", 
         acctnum -> { BankAccount result = new SavingsAccount(acctnum);
                      result.deposit(1000); // $10 for free!
                      return result; });

   private String name;
   private AccountFactory af;

   private AccountFactories(String name, AccountFactory af) {
      this.name = name;
      this.af = af;
   }

   public BankAccount create(int acctnum) {
      return af.create(acctnum);
   }

   public String toString() {
      return name;
   }
}
