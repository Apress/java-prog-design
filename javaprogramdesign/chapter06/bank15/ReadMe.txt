Banking Demo, Version 15.

Bank has the methods iterator and stream.  

There are two new classes, IteratorAcctStats and
StreamAcctStats, which are clients of Bank.
The methods in these classes support two tasks: 
to print some selected accounts, and to find the maximum 
balance of some selected accounts.

There is a new interface, Visitor, which supports the
visitor pattern by adding the method "result" to the
Consumer interface.
MaxBalanceVistor is an example class that implements Visitor.

The programs IteratorStatProgram and StreamStatProgram 
test these two classes.