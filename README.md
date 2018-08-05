# Cracking the Coding Interview

Missing chapters:
* Chapter III: special situations
* Chapter V: behavioral questions
* Chapter VII: technical questions

To be reviewed:
* Ascii vs unicode?
* Bit vector? (1 << val)
* End of array character \0?
* getCharNumber p 196
* LinkedList java
* Stack and queue basic implementation
* Merge sort, quick sort

Exercices to be reviewed:
* Solution 3 p197
* Ex 1.7 p024
* Ex 2.8
* Ex 3.1
* Ex 3.5

## General

* Make sure to not be blocked on a wrong hypothesis
* Draw a current situation and after

## Java API

* String.charAt(i)
* Arrays.sort([])
* for(int i=0, j=0, i<5; i++, j++)
* String.toCharArray()
* boolean instead of int if possible
* StringBuilder with initial capacity
* LinkedList benefit: add or remove item from the beginnin in constant time

## Big O

To be reviewed:
* Ex 8
* Ex 9
* Ex 12
* Ex 14
* Ex v 1.6, 1.9, 1.10, 1.11, 1.11

Big O: upper bound

Big Omega: lower bound (fastest)
 
Big Theta: Theta(N) if both O(N) and Omega(N)

--

2^p = Q <=> log Q = P

O(2^log n) = O(n)

Square root: √

--

O(2n) = O(n)

O(n² + n) = O(n²)

O(n + log N) = O(n)

O(x + 2x + 3x + ... + nx) = O(n²x)

--

O(n) may refer to time and space (memory)
Recursivity => space as each call is added to the call stack

Amortized time: worst case happens every x.
Equals the sum of all operation costs divided by the number of operations

O(log n) => algorithms which starts with n elements, then n/2, then n/4 etc.
E.g. binary search in a sorted array.
If halved each time (reduce by 2), likely be a O(log n.)

Recursive function that makes multiple calls: often O(branches^depth) with branches the number of times each recursive call branches.
E.g. ```return f(n-1) + f(n-1)``` => O(2^n)

```java
void print(int[] a, int[] b) {
    for(int i=0; i<a.length; i++) {
        for(int j=0; j<b.length; j++) {
            if(a[i]) < b[j]) {
	            System.out.println("foo")
            }
        }	
    }
}
```
Not an O(n²) as both a and b matters, so O(ab)

We should use N only if there is no ambiguity

## Linked list

Make sure to ask during the interview whether it is a single or a doubly list

Runner technique: second pointer moving slower or faster than the first one.
E.g. a second pointer moving to 2 elements instead of 1

If you're having trouble solving a liked list problem, you should explore if a recursive approach will work

Recursive algo: at least O(n) space (due to recursive calls)

## Stacks and Queues

* Stack: LIFO
* Queue: FIFO

Stack are useful with recursivity

Stack & queue: not constant access to the ith item but constant access with add and remove


