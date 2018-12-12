Banking Demo, Version 4

This version improves the BankAccount class by giving it 
more responsibilities (interest rate, and the methods
deposit, toString, addInterest, and hasEnoughCollateral).

The Bank class is modified so that it delegates to 
these new methods.

The classes have been modified to uses dependency injection:
The Bank gets its map of accounts and its nextacct value via its constructor.
The BankClient gets its input stream and Bank object via its constructor.
The BankProgram is responsible for creating these things.
