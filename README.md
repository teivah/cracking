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

* Arrays.sort([])
* for(int i=0, j=0, i<5; i++, j++)
* boolean instead of int if possible
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

## Arrays and Strings

Arrays and Strings questions are interchangeable

String.charAt(i)

String.toCharArray()

StringBuilder with initial capacity

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

Stack:
* pop()
* push(item)
* peek()
* isEmpty()

Queue:
* add(item)
* remove()
* peek()
* isEmpty()

## Trees and Graphs

Binary tree: tree with each node has up to two children

Binary search tree: binary tree in which every node must fit the property _all left descendents <= n < all right descendents_

Balanced binary tree: left and right subtrees may not be exactly the same size but balance enough to ensure O(log n) times for insert and find

Complete binary tree: every level of the tree is fully filled (with last level filled from the left to the right)

```
   1
  / \
 2
```
=> complete binary tree

```
   1
  / \
     2
``` 
=> not a complete binary tree

Full binary tree: every node has either zero or two children

Perfect binary tree: full and complete (1, 2, 4 etc. nodes)

In-order traversal
```java
void traverse(TreeNode node) {
	if(node != null) {
		traverse(node.left);
		visit(node)
		traverse(node.right)
	}
}
```

Pre-order (current before child nodes)
```java
void traverse(TreeNode node) {
	if(node != null) {
		visit(node)
		traverse(node.left);
		traverse(node.right)
	}
}
```

Post-order (current node after its child nodes)
```java
void traverse(TreeNode node) {
	if(node != null) {
		traverse(node.left);
		traverse(node.right)
		visit(node)
	}
}
```

Min-heap: 
* Complete binary tree where each node is smaller than its children
* Insert is started by inserting the element at the bottom (to maintain the complete tree property), then swapping with its parent (O(log n))
* Extract min element: remove the root (min), then swap it with the bottommost/rightmost element, then we try to fix the new root by either swapping it with the left or the right (min of the two children)

Tries (prefix trees):
* n-ary tree in which characters are stored at each node
* Each path down the tree may represent a word
* Null node to indicate a complete word


A tree is a type of graph

A graph may contain cycle (acyclic graph: without cycles)

Adjacency list:
* Most common way to represent a graph
* Every vertex (or node) stores a list of adjacent verticles