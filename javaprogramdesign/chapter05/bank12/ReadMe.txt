Banking Demo, Version 12

The version revises Version 10.  It uses enums to simplify the 
handling of input commands and the OwnerStrategy hierarchy.

The strategy classes Domestic and Foreign are replaced by the enum 
Owners. The AbstractBankAccount constructor and its method 
setForeign are modified to use these enums. 

The eight InputCommand strategy classes QuitCmd, NewCmd, etc. 
have been replaced by the single enum InputCommands.
The global variable "commands" in BankClient is now initialized
by calling InputCommands.values.

The new interface AccountFactory contains a static factory method 
for each of the three types of bank account:
createSavings, createRegularChecking, and createInterestChecking.
It also has a static method createAccount, which uses the type
number to determine which account to create.

The method createSavingsWithDeposit in BankAccount has been
rewritten to mention AccountFactory.createSavings.

The methods newAccount in Bank and readAccount in SavedBankInfo 
are modified to call the createAccount method in AccountFactory.
