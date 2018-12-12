Banking Demo, Version 5

This version introduces the interface BankAccount, with
implementing classes SavingsAccount and CheckingAccount.

The BankAccount method headers all have the keywords
"public abstract". These keywords are optional, and are
omitted from subsequent versions of the interface.

The class SavingsAccount is a copy of the version 4 BankAccount
code except that it has "implements BankAccount" in its header.

The class CheckingAccount is similar to SavingsAccount, except 
that it has different code for the hasEnoughCollateral and toString
methods. It also does not have an addInterest method.

The class BankClient is modified so that the user specifies a 
savings account or checking account when creating a new account.

The class Bank is modified so that its newAccount constructor
has an argument denoting the account type, and creates a
new SavingsAccount or CheckingAccount object as appropriate.
 

