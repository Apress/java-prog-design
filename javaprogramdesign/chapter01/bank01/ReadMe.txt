Banking Demo, Version 1

The initial, non-object-oriented banking demo.

This program consists of a single class, named BankProgram. This class holds a map 
that stores the balances of several savings accounts held by a bank. Each element 
in the map is a key-value pair. The key is an integer that denotes the account number, 
and its value is the balance of that account, in cents.

The program runs as a loop that executes commands from the console. There are seven commands: 
0) quit, which exits the loop.
1) new, which inserts a new element into the map, assigning it a new account number 
   and an initial balance of 0.
3) get, which prints the balance of a given account.
4) deposit, which increases the balance of a given account by a specified number of cents.
5) authorizeloan, which determines whether an account has enough money to be used as 
   collateral for a loan.  The criterion is that the account must contain at least half 
   of the loan amount.
6) show, which prints the balance of every account.
7) interest, which increases the balance of each account by a fixed interest rate.
