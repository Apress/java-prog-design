Chapter 9 Cookbook Example

The classes here use the composite pattern to implement a 
sample online cookbook application.
The class Cookbook contains the main method.

FoodItem is the composite interface. Recipe is the recursive
class and BasicFood is the base class.

FoodItem implements Iterable. It has a default iterator method
that creates a FoodIterator object. FoodIterator uses a
stack of child iterators to implement a non-recursive 
traversal of the stack.
