Chapter 3 Thread Example

The class ReadLine blocks until an input line is entered.
It then sets the variable done to true.

ThreadTest runs ReadLine in a separate thread, and starts
printing integers. It stops when ReadLine's variable done
is true.

