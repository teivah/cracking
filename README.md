# Cracking the Coding Interview

To be reviewed:
* Chapter III: special situations
* Chapter V: behavioral questions
* Chapter VII: technical questions
* Ascii vs unicode?
* Bit vector? (1 << val)
* End of array character \0?
* getCharNumber p 196
* LinkedList java
* Stack and queue basic implementation
* Merge sort, quick sort
* Map, entrySet, iteration
* Graph Java implementation?
* From 4.9
* Bit manipulation exercices
* Chapter 6
* Chapter 7
* BigInteger vs Long
* HashSet
* https://www.youtube.com/watch?v=uQdy914JRKQ
* From 8.13
* Why does asynchronous scale better?
* Asynchronous IO
* From 9.1

Exercices to be reviewed:
* Solution 3 p197
* Ex 1.7 p024
* Ex 2.8
* Ex 3.1
* Ex 3.5
* Ex 4.2
* Ex 4.4
* Ex 4.6
* Ex 4.7
* Ex 8.4
* Ex 8.5
* Ex 8.6

## Java

Set.toArray()

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

Queue implementation => LinkedList:
* LinkedList.removeFirst() to dequeue()

## Trees and Graphs

Binary tree: tree with each node has up to two children

Binary search tree: binary tree in which every node must fit the property _all left descendents <= n < all right descendents_
*All nodes*!

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

Adjacency matrix:
* N*N boolean matrix (N the number of nodes) where a true at matrix[i][j] means an edge from node i to node j
* Undirected graph (no direction for an edge), an adjacency matrix will be symmetric but it's not necessarily the case with a directed graph

Graph search:
* Depth-first (DFS): explore each branch completely before moving on to the next branch
* Breadth-first (BFS): start at the root (or any node) and explore each neighbor before going on to any of their children

Shortest path: BFS is generally better

DFS:
```java
void dfs(Node root) {
	if(root == null) return;
	root.visited = true;
	visit(root) // Do something with root
	
	for(Node n: root.adjacent) {
		if(!n.visited) {
			search(n)
		}
	}
}
```

BFS (not recursive, using a queue):
```java
void bfs(Node root) {
	LinkedList<Node> queue = new LinkedList<>();
	root.visited = true;
	queue.enqueue(root);
	
	while(!queue.isEmpty()) {
		Node r = queue.remove();
		visit(t);
		for(Node n : r.adjacent) {
			if(!n.visited) {
				n.visited = true;
				queue.enqueue(n);
			}
		}
	}
}
```

Bidirectional search:
* Used to find the shortest path between a source and a destination node
* Two simultaneous bredth-first searches, one from each node

Java tree => TreeNode:
* int getChildCount()
* getChildAt(int)
* TreeNode getParent()
* boolean isLeaf()

Graph API:
* createNode(data)
* addEdge(first, second)

Last: 4.9

## Bit manipulation

* ```&``` AND bit by bit (n & n = n, 2 & 1 = 1)
* ```|``` OR bit by bit (n | n = n)
* ```^``` XOR bit by bit
* ```<<``` shift on the left
* ```>>``` shift on the right
* ```~``` complement

* n * 2 => shift on the left by 1 (0110 << 1 = 1100)
* n * 4 => shift on the left by 2 (0011 << 2 = 1100)

0s: sequence of 0

Tricks:
* x ^ 0s = x
* x ^ 1s = ~x
* x ^ x = 0
* x & 0s = 0
* x & 1s = x 
* x & x = x
* x | 0s = x
* x | 1s = 1s 
* x | x = x

Two complement and negative numbers?

* ```>>``` arithmetic shift
* ```>>>``` logical shift (shift the sign bit as well)

Get bit:
```java
boolean getBit(final int num, final int i) {
    return ((num & (1 << i)) != 0);
}
```

Set bit:
```java
int setBit(final int num, final int i) {
    return num | (1 << i);
}
```

Clear bit:
```java
int clearBit(final int num, final int i) {
    final int mask = ~(1 << i);
    return num & mask;
}
```

Clear bits from most significant one to i:
```java
int clearBitsFromMsbToI(int num, int i) {
    int mask = (1 << i) - 1;
    return num & mask;
}
```

Clear bits from i to 0:
```java
int clearBitsFromITo0(int num, int i) {
    int mask = (-1 << (i + 1));
    return num & mask;
}
```

Update a bit:
```java
int updateBit(int num, int i, boolean bit) {
    int value = bit ? 1 : 0;
    int mask = ~(1 << i);
    return (num & mask) | (value << i);
}
```

## OO

* Questions intentionally vague => to be clarified
* Identify the core objects
* Analyze relationships
* Investigate actions

Questions to be asked: who, what, where, when, how, why

## Recursion and Dynamic Programming

Good candidate for recursion:
* "... to compute the nth..."
* "... to list the first n..."
* "... to compute all..."

Bottom-up approach: start with 1 element, then 2, then 3 etc.
Top-down approach: how to divide the problem for case N into subproblems

Recursive implementations: at least O(n) memory

Memoization (dynamic programming): caching results for future recursive calls

/!\ Using x and y when dealing with two-dimensional array => m[y][x]

Permutation algorithm:
```java
List<String> f(String s) {
	List<String> result = new ArrayList<>();
	f("", str, result);
	return result;
}

void f(String prefix, String suffix, List<String> result) {
	int len = suffix.length();
	if(len == 0) {
		result.add(prefix);
		return;
	}
	
	for(int i=0; i<len; i++) {
		String before = suffix.substring(0, i);
		String after = suffix.substring(i+1, len);
		char c = suffix.charAt(i);
		f(prefix + c, before + after, result);
	}
}
```

Loop in a recursive method => code smell? The loop isn't already managed by the recursion?

**In a recursion, we should not use a List and to add and remove elements, instead, use an array with an index (a[i] = 0, a[i] = 1 etc.)**

## Systems Design and Scalability

1. Scope the problem
2. Make assumptions
3. Major components
4. Key issues
5. Redesign for key issues

Denormalization: adding redundant information into a database to speed up reads

DB partitioning (sharding):
* Vertical: by feature
* Key or hash based
* Directory based: lookup table for where the data can be found (spof)

Bandwidth: maximum amount of data that can be transferred in a unit of time

Considerations:
* Failure
* Availability
* Reliability: probability that a system is operational for a certain unit of time
* Read-heavy vs write-heavy
* Security

## Sorting and Searching

