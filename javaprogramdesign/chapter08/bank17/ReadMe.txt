Banking Demo, Version 17.

This version modifies version 16 to enable three forms of decoration.

First, bank accounts are decorated. There is a new abstract class
BankAccountWrapper and decorator subclasses UnmodifiableAccount 
and SuspiciousAccount.

Second, there is a new class UnmodifiableBankIterator, 
which decorates Iterator<BankAccount>.

Third, there is a decorator hierarchy to do loan authorization.
There is a new interface LoanAuthorizer, a wrapper class
AuthorizerWrapper, a base class CollateralAuthorizer, and 
decorator classes GoodCustomerAuthorizer and CreditScoreAuthorizer.

The class Bank is modified in several ways. Its method iterator 
is modified to return an unmodifiable iterator of unmodifiable 
bank accounts. It also has a new method makeSuspicious, 
which decorates a given account with a SuspiciousAccount wrapper.
Finally, its authorizeLoan method is modified to use a 
LoanAuthorizer decorator.
