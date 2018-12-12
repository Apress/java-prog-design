Banking Demo, Version 8.

CheckingAccount is now an abstract class, having
the subclasses RegularChecking and InterestChecking.

CheckingAccount keeps the implementation of the method
hasEnoughCollateral.  The methods toString and addInterest
are abstract, and are implemented in its subclasses.

Bank's newAccount method is modified so that type==2 creates
a new RegularChecking object.
 
BankProgram has been modified so that it reads the bank's initial
account information from a file when the program begins,
and writes the account information to the file when the program ends. 
It uses the class SavedBankInfo to interact with the file.
The public method nextAcctNum is added to Bank, 
so that the value of its nextAcct variable can be saved.
