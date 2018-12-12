Banking Demo, Version 7.

AbstractBankAccount is an abstract class that contains
the common variables and methods of SavingsAccount and
CheckingAccount, namely the variables acctnum and balance, 
and the methods getAcctNum, getBalance, deposit, compareTo,
and equals.

AbstractBankAccount also gets abstract methods for toString,
hasEnoughCollateral, and addInterest.

CheckingAccount has the new subclass InterestChecking.  

The processCommand method in BankClient is modified to
support requests for new interest checking accounts.

The newAcount method in Bank is modified to create new
InterestChecking objects. 
