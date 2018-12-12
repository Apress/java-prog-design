Banking Demo, Version 18.

The demo is modified to allow Bank to be an observable. 
The observer interface is BankObserver. 

The bank supports four different event types, which are
defined in the enum BankEvent.

The Bank class is modified to implement a map of BankObserver 
observer lists, one for each event type.
Bank has the methods addObserver and notifyObservers. The Bank
methods that update accounts are modified to call notifyObservers.

The Bank class gets a new method isForeign, which could be needed by
observers that use pull. That method should probably have
existed since version 3, but had been omitted in the interest
of simplicity.

There is a new class Auditor that implements BankObserver.

BankProgram is modified to add two observers to the bank.
