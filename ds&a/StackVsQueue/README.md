# Stacks
A stack is an abstract, linear data type with a predefined capacity (or boundary). It follows a particular order for adding or removing elements. In this demo we create our own custom `SimpleStack` class to demonstrate the functionality of the `Stack` class within the `java.util` package that the JRE provides us.

<img src="https://github.com/210823-Enterprise/demos/blob/main/ds%26a/StackVsQueue/imgs/java-stack2.png">

Let us conceptualize stacks using a stack of plates placed in a box. The first plate placed in the stack (the plate at the bottom of the stack) will be the last one to be removed, and the plate added last would be the first to be removed.

This is called the **Last In First Out (LIFO) or First In Last Out (FILO) ordering**.

Stacks are used in a variety of ways when we code. We use stacks to implement functions, parsers, expression evaluation, and some algorithms. Stacks are great for processing nested structures, so they are important for understanding recursion.

> A simple real-world application of a stack is reversing a string letter by letter. Another good example of a data stack is the undo and redo function on a computer or text editor. Undo removes your most recent change, and redo builds upon already existing changes.

<br>

# Queues
A queue is a lot like a stack. A Queue is also a linear structure that follows a First In First Out (FIFO) order, but they differ in how elements are removed. Queues are open from both ends: one end for inserting data (enqueue), and the other end for removing data (dequeue). A stack is only open from one end.

> **Simplified:** for a stack we remove the most recently added element, but for a queue, we remove the “oldest” element.

It's worth noting that some lists are queues. Look at [**LinkedList**](https://docs.oracle.com/javase/6/docs/api/java/util/LinkedList.html), for example.

### After Demoing
Complete this [Hackerrank Challenge](https://www.hackerrank.com/challenges/queue-using-two-stacks/problem)
