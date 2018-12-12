Chapter 6 Iteration Examples

NoDuplicates shows the need to separate an iterator from its iterable.
Its isUnique method creates a new iterator each time it is called.

RandomIterator and PrimeIterator illustrate some simple Iterator
classes. RandomIterator's main method prints the number of
integers it has to generate until a repeat occurs. PrimeIterator's
main method prints the first 100 primes. 

PrimeCollection creates a Collection class by extending
AbstractCollection. It uses the PrimeIterator class as its
implementation of the iterator method.
 