package javaprogramdesign.chapter10.bank18;

import java.util.*;
import java.util.stream.Stream;

public class Bank implements Iterable<BankAccount> {
   private Map<Integer,BankAccount> accounts;
   private int nextacct;
   private Map<BankEvent,List<BankObserver>> observers = new HashMap<>();

   public Bank(Map<Integer,BankAccount> accounts, int n) {
      this.accounts = accounts;
      nextacct = n;
      for (BankEvent e : BankEvent.values())
         observers.put(e, new ArrayList<BankObserver>());
   }

   public void addObserver(BankEvent e, BankObserver obs) {
      observers.get(e).add(obs);
   }  

   public void notifyObservers(BankEvent e, BankAccount ba, int depositamt) {
      for (BankObserver obs : observers.get(e))
         obs.update(e, ba, depositamt);
   }

   public int newAccount(int type, boolean isforeign) {
      int acctnum = nextacct++;
      BankAccount ba = AccountFactory.createAccount(type, acctnum);
      ba.setForeign(isforeign);
      accounts.put(acctnum, ba);
      notifyObservers(BankEvent.NEW, ba, 0);
      return acctnum;
   }

   public int getBalance(int acctnum) {
      BankAccount ba = accounts.get(acctnum);
      return ba.getBalance();
   }

   public void setForeign(int acctnum, boolean isforeign) {
      BankAccount ba = accounts.get(acctnum);
      ba.setForeign(isforeign);
      notifyObservers(BankEvent.SETFOREIGN, ba, 0);
   }

   public void deposit(int acctnum, int amt) {
      BankAccount ba = accounts.get(acctnum);
      ba.deposit(amt);
      notifyObservers(BankEvent.DEPOSIT, ba, amt);
   }

   public boolean authorizeLoan(int acctnum, int loanamt) {
      BankAccount ba = accounts.get(acctnum);
      LoanAuthorizer auth = LoanAuthorizer.getAuthorizer(ba);
      return auth.authorizeLoan(loanamt);
   }

   public String toString() {
      String result = "The bank has " + accounts.size() + " accounts.";
      for (BankAccount ba : accounts.values())
         result += "\n\t" + ba.toString();
      return result;
   }

   public void addInterest() {
      for (BankAccount ba : accounts.values())
         ba.addInterest();
      notifyObservers(BankEvent.INTEREST, null, 0);
   }

   public int nextAcctNum() {
      return nextacct;
   }

   public Iterator<BankAccount> iterator() {
      Iterator<BankAccount> iter = accounts.values().iterator();
      return new UnmodifiableBankIterator(iter);
   }

   public Stream<BankAccount> stream() {
      return accounts.values().stream();
   }

   public Collection<Loan> loans() {
      return new ArrayList<Loan>();
   }

   public void makeSuspicious(int acctnum) {
      BankAccount ba = accounts.get(acctnum);
      ba = new SuspiciousAccount(ba);
      accounts.put(acctnum, ba);
   }

   public boolean isForeign(int acctnum) {
      BankAccount ba = accounts.get(acctnum);
      return ba.isForeign();
   }
}
