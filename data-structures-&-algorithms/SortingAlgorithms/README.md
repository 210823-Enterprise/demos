# Sorting Algorithms
A Sorting Algorithm is used to rearrange a given array or list elements according to a comparison operator on the elements. The comparison operator is used to decide the new order of element in the respective data structure.

The 5 most popular sorting algorithms in Java are:
1. **Merge Sort**
2. Heap Sort
3. Insertion Sort
4. Selection Sort
5. Bubble Sort

## Merge Sort
Merge Sort uses the **divide and conquer** strategy for sorting elements in an array.  It works by recursively breaking down a problem into two or more sub-problems of the same or related type, until these become simple enough to be solved directly.  This is called a **Divide and Conquer** approach. The solutions to the sub-problems are then combined to give a solution to the original problem.

Merge Sort's runtime is **linearithmic O(n log n)**, which is much faster/ requires less operations than Insertion or Selection Sort O(n<sup>2</sup>).

Take a look at the diagram below.  Which would be faster to sort?

<img src="imgs/guess.png">