# Week 3: Java SE API's and Multithreading
*Be sure to study the following questions.  On Monday Sept.  13th, I will ask you some of the following questions. Additionally you should review the 
following study guides on the previous week.  All of this material will include the questions you could be asked on **Sept. 20th's QC.** <br>
> - [SQL & JDBC](https://github.com/210823-Enterprise/demos/blob/main/week2/qc-questions.md) <br>

<br>

> :star: In conjunction to studying the below topics, if you haven't attempted the Hackerrank Challenge, please attempt to solve 2 out of the 3 challenges [here](https://www.hackerrank.com/210823-enterprise-hrextra) :star:

<br>

What to expect on **Monday** ?
- 10:00am Quiz: regarding Java SE API's Relfection, and Collections.
- QC at 2pm (60 min to solve 3 coding challenges)
- begin Multithreading on **Tuesday**



## Threads
1. What is multi-threading?
    + Handling multiple threads / paths of execution in your program.

2. In what ways can you create a thread?
   + By extending the Thread Class or by implementing the `Runnable` Interface. You must call Thread's `.start()` method to start it as a new thread of execution.

3. Lifecycle of a thread
    + When created, in NEW state.
    + When `.start()` is called, it goes to RUNNABLE state.
    + When `.run()` is called, goes to RUNNING state.
    + If `.sleep()` or `.wait()` is called, will go to WAITING.
    + If dependent on another thread to release a lock, it will go to BLOCKED state.
    + When finished executing, will be in DEAD state and cannot be restarted.

4. What is deadlock?
    + When two or more threads are waiting on locks held by the others, such that no thread can execute

5. What is synchronized keyword?
    + Only allowing one thread access to the method or variable at a time - enforces thread-safety

6. Explain the [Producer/Consumer Problem](https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/).

7. What does `.wait()` do to a thread? `.notify()`? [Resource](https://www.baeldung.com/java-wait-notify)

8. Why is Thread Pooling important? What about JDBC pooling?

<br>

## Advanced Java
- What are lambdas and why are they useful in Java?

- What is a **functional interface**? Name a few included in the JRE:
  - Predicate - `test()`
  - Consumer - `accept()`
  - Supplier - `get()`

- What is an Anonymous Class? Can you give an example of when we've used one?

- Can a class be `static`? 
  - Great resource on this [here](https://www.javatpoint.com/why-we-use-static-class-in-java) :point_left:

- What is the difference between the `Comparator` and `Comparable` Interface?
  - Very clear resource [here](https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/) :point_left:

<br>

## Collections (review)
- Describe the `Iterable` interface. [Resource](https://www.geeksforgeeks.org/iterable-interface-in-java/)
  - Root Interface of the Java Collections API

- What is an `iterator()`?
  - You can iterate the elements of a Java Iterable (an object of a class that implements `Iterable interface`) by obtaining a Java Iterator from it by calling the Iterable `iterator()` method. 

<br>

```java
List<String> list = new ArrayList><();

list.add("one");
list.add("two");
list.add("three");

Iterator<String> iterator = list.iterator();

while(iterator.hasNext()) {
    String element = iterator.next();
    System.out.println( element );
}
```

<br>

- What is the **time complexity (Big O notation)** of insertion from an ArrayList?
  - Big O Notation of **search from an ArrayList**?
  - Big O notation of **search from a LinkedList**?
  - Big O Notation of **search, insert & delete from a Hashmap**?

- What's the difference between TreeMap and HashMap?





























