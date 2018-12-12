Testing the Comparator Interface.

The program ComparatorBankAccounts revises the program 
CompareBankccounts from Chapter 2.  It imports the BankAccount 
definitions from version 10 of the banking demo.

The class AcctByMinBal implements Comparator<BankAccount>, and is the 
basic way to create a comparator.

ComparatorBankAccounts defines four Comparator interfaces. The first uses
AcctByMinBal. The second uses an anonymous inner class.  The third and 
fourth use lambda expressions.
