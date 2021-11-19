# Searching Algorithms

- **Basic Linear Search** - O(n) Linear
- **Binary Search** - O(log n) Logarithmic
  > *Logarithmic running time (O(log n)) essentially means that the running time grows in proportion to the logarithm of the input size - as an example, if 10 items takes at most some amount of time x, and 100 items takes at most, say, 2x, and 10,000 items takes at most 4x, then it's looking like an O(log n) time complexity.*
<br>
- **Recursive Search**

## Binary Search
Imagine that you have a shelf of books and you are looking for a book authored by *Shakespear*.  With Linear search, you would start from the beginning and check each book.  The faster approach (O(log n)) would be by using **Binary Search**.

> The collection must be **sorted** to apply Binary search

- Imagine that the books are **sorted by last name**.
- With Binary Search you would **first located the center of the book shelf**.
- Imagine the book in the center of the shelf is authored by someone with a last name starting with "U".

<br>

> [ P Q R S T **U** V W X Y Z]

<br>

- Since "S" is *less than* "U", we can eliminate the entire right half of the book shelf, only searching between "P" - "T".

<br>

> [ P Q R S T ~~**U** V W X Y Z~~]

<br>

- We repeat this process, continuously finding the midpoint and checking whether our target value is greater than or less than, until we find "S".

<br>

> [ P Q **R** S T] <br>
> [ ~~P Q **R**~~ S T] <br> 
> [ **S** ~~T~~]

<br>

Binary Search on a *sorted* array looks like this:

<br>

```java
public static int binarySearch(int[] arr, int x) {
    int min = 0;
    int max = arr.length - 1;

    while (min <= max) {
        
        int mid = (min + max) / 2;
        
        if (x < arr[mid]) { // if the target value is less than
            max = mid - 1; // the midpoint, we discard the RHS
        } else if (x > arr[mid]) {
            min = mid + 1; // otherwise we discard the LHS
        } else {
            return mid;
        }
    }
    return -1;
}
```

<br>

