Testing the Comparable Interface.

CompareSavingsAccounts compares SavingsAccount objects.  
CompareBankAccounts compares objects that implement BankAccount.
Both work with version 6 (or higher) of the banking demo.

Both programs compare bank accounts by their natural order. 
They each create a list of accounts and then calculate the account 
having the largest balance. The programs calculate the largest balance
in two ways. 

The first way is use the method findMax to do a linear search of the list. 
The second way is to use the method Collections.max from the Java library.

