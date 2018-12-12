Banking Demo, Version 6

The BankAccount interface now has the method addInterest,
to support transparency. It also extends Comparable<BankAccount>,
and contains a static method createSavingsWithDeposit 
and a default method isEmpty.

The CheckingAccount class now has the addInterest method, and
both CheckingAccount and SavingsAccount have a compareTo method.
They also both explicitly implement Comparable<BankAccount>. This
is redundant, given that BankAccount also implements Comparable,
but is not illegal. Future versions will drop this.

The Bank's addInterest method has been modified to be transparent.

The variables named "accounts" in Bank and BankProgram 
have been modified to be a Map instead of a HashMap.

