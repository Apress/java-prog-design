Banking Demo, Version 14.

The three AccountFactory subclasses have been replaced by
the enum AccountFactories.

The AccountFactory static methods have been revised to
use AccountFactories. The createAccount method has been
revised to index into the array AccountFactories.values
instead of using an if statement.

InputCommands is rewritten to also use AccountFactories.values
to create its "new account type" message. The NEW command prints
that message to the user.

