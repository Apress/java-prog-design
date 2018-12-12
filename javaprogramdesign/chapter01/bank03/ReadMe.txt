Banking Demo, Version 3

Introduces the new class BankAccount.  The class Bank is
modified to contain a map of BankAccount objects.

In addition to the balance, an account also keeps track of
whether the account owner is foreign or domestic. 

BankClient gets a new command (command 7) to allow 
the user to set the account ownership to foreign or domestic. 
The newAccount command is modified to request the initial ownership.

Bank's toString method is modified to also display the ownership
of each account.