Banking Demo, Version 9.

The AbstractBankAccount class has been redesigned to use the
template pattern. In particular, the class now partially implements 
the methods hasEnoughCollateral, toString, and applyInterest,
using the abstract methods collateralRatio, accountType, 
and interestRate.

SavingsAccount is rewritten to implement those abstract methods.

CheckingAccount is rewritten so implement collateralRatio,
and declares accountType and interestRate to be abstract.

RegularChecking and InterestChecking are rewritten to implement
accountType and interestRate.
