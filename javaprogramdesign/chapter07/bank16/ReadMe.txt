Banking Demo, Version 16.

This version contains a new implementation of SavedBankInfo that 
uses object streams. To make this possible, BankAccount and 
OwnerStrategy are modified so that they extend Serializable.

This version contains new files to support the FBI scenario.
There is a new interface FBIAcctInfo, and new
classes Loan, BankAccountAdapter, LoanAdapter and FBIClient.
The class Bank has a dummy method loans, which returns an empty list.
