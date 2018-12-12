Chapter 4 IntProcessor Example

The two example programs illustrate the commonalities of
the template and strategy patterns.

The IntProcessorTemplate class has two subclasses,
AddOneTemplate and AddTwoTemplate, each of which implements
the abstract method f.

The IntProcessorStrategy class has a variable op,
which references a class that implements the strategy
interface Operation. The classes AddOneStrategy and
AddTwoStrategy implement Operation.
