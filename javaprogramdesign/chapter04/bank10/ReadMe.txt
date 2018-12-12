Banking Demo, Version 10.

Bank accounts have a maintenance fee. Foreign accounts 
have a fee of 500, whereas domestic accounts have no fee.

Owner information (including fees) are implemented 
using the strategy pattern.

There is an interface OwnerStrategy, having the methods isForeign,
location, and fee. There are two OwnerStrategy implementation 
classes, Domestic and Foreign.

The AbstractBankAccount class replaces the boolean variable isforeign
with the OwnerStrategy variable owner. Its isForeign method now
calls owner.isForeign.  

The interface BankAccount has the new method fee. AbstractBankAccount  
implements it by calling owner.fee. Its toString method is modified to 
display the fee. It also calls location to get the string
"foreign" or "domestic", instead of using an if-statement.

The value of the owner variable is initially set to a new Domestic object.
The setForeign method resets the owner variable based on the 
method's argument.

Some of the BankClient responsibilities have been off-loaded
to the new command interface InputCommand, which has
the eight implementing classes QuitCmd, NewCmd, SelectCmd, 
DepositCmd, LoanCmd, ShowCmd, InterestCmd, and SetForeignCmd. 
The BankClient class is modified to hold an array of 
command objects from these classes.
Its run method uses this array instead of an if-statement.
