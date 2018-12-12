Banking Demo, Version 11.

AbstractBankAccount is no longer an abstract class and has no
subclasses. Instead, the information that was provided by the
subclasses is now provided by the strategy interface
TypeStrategy and its implementing subclasses SavingsType,
RegularCheckingType, and InterestCheckingType.

The TypeStrategy methods implement the same 3 methods that
were previously abstract in AbstractBankAccount: 
collateralRatio, accountType, and interestRate.

AbstractBankAccount has a variable ts that holds its
TypeStrategy object. Its methods collateralRatio, accountType, 
and interestRate call the corresponding TypeStrategy methods.

The Bank's newAccount method has been modified to create the proper
TypeStrategy object and to pass it to the AbstractBankAccount constructor.

The BankAccount static method createSavingsWithDeposit 
and the SavedBankInfo methods have been modified similarly.

This version of the demo is a dead end. Subsequent versions
are based on version 10.

