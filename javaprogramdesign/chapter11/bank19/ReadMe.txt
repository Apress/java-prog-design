Banking Demo, Version 19.

The bank-related code from BankClient and InputCommands
is moved to the new class InputController. BankProgram 
is modified to create the InputController object and
connect it to the bank client.

The classes StreamStatProgram and StreamAccountStats are modified 
to use MVC. The new classes are StreamStatProgram, 
StreamStatModel, StreamStatController, and StreamStatView.

A JavaFX interface to the banking demo is created. There are
JavaFX classes for three views and their associated controllers: 
AllView, AllController, InfoView, InfoController, CreationView, 
and CreationController. When one view causes the model to change,
that change is reflected in all relevant views.

There is also an alternative view AllView2, which uses a
ListView control to display the account information. This
control is connected to an observable list which is managed
by the new class AllController2.

There is also an alternative view AllView3, which uses a
TableView control to display the account information. This
class can use AllController2 as its controller.
