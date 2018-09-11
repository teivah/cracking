# Cracking the Coding Interview

## General

Notes:
* to: included
* until: excluded
* odd: impair
* even: pair

Power of two:
* 2^0 	1
* 2^1 	2
* 2^2 	4
* 2^3 	8
* 2^4 	16
* 2^5 	32
* 2^6 	64
* 2^7 	128
* 2^8 	256
* 2^9 	512
* 2^10	1024
* 2^11	2048
* 2^12	4096
* 2^13	8192
* 2^14	16384
* 2^15	32768
* 2^16	65536
* 2^17	131072
* 2^18	262144
* 2^19	524288
* 2^20	1048576
* 2^21	2097152

Summary:
* Stack: push, pop
* Queue: add, poll
* int []array => array.length
* List list => list.size();
* In-order: left-root-right (order)
* Pre-order: root-left-right
* Post-order: left-right-root
* Merge sort: 
    * Time is O(n log(n)) and memory is O(n)
    * Divide into two parts and merge them (using a helper and + 1)
* Quick sort:
    * Time is O(n log(n)) average, O(n²) worst case, memory is O(log(n))
    * Pick a random element and partition the array such that all numbers that are less than the pivot come before all elements that are greater than it
    * Sort left, sort right
    * Use - 1
* Bubble sort: two loops, second loop `for (int j = 0; j < n-i-1; j++)`
* Matrix: use m[row][col] instead of m[y][x]
* If question with modulo, it has to be applied during each addition
* String is immutable so we can modify the internal char array without modifying the string value

Process:
* Listen all information
* Brute force
* Optimize with unused information. If blocked, use examples.
* Solve it on examples
* Time & space
* Implementation
* Test before to submit: review lines + small test

Optimization:
* **Do it yourself with a big concrete example and derive an algorithm**
* Base case and build. Start from the base case (e.g. n=1) and then try to build up from here.
* Simplify and generalize. Example: with a non-sorted array etc. What if the array was sorted? If we solve the problem this way we just have to generalize to the initial problem.

Final Optimization:
* Check bottlenecks (O(n²) then O(n logn) then O(n) etc.). Dynamic programming then memoization (matrix etc.) to reduce the time complexity without any call stack

General:
* Make sure to not be blocked on a wrong hypothesis
* Draw a situation currently and after
* Sum of integers may give a long
* Exercices with an array, test if a solution is applicable if the array was sorted
    * Then start with the smaller/greater and see if it help resolving the problem
* If the traverse a tree and we want to get the final number representing the root-to-leaf path (1->2->3 => 123), we can recurse by multiplying by 10 each time the current sum
* Finding median of three numbers: calculate sum, remove min and remove max
* Constant extra space: O(1)

http://bigocheatsheet.com/

## Java

### Notes

* Overloading: two methods with the same same but different number or type of arguments
* Overriding: method inherited

Return in a try => finally is called

Finalize: called by the GC

Vector: same than ArrayList but synchronized

LinkedList vs ArrayList:
* Search with LinkedList: O(n)
* Search with ArrayList: O(1)
* Insert/Deletion with LinkedList: O(1)
* Insert/Deletion with ArrayList: O(1) worst case (last/first element) and O(n) best case (first/last element)

Other collections:
* HashMap: O(1) lookup and insertion (implemented using an array of linked lists)
* TreeMap: O(log N) lookup and insertion but keys are ordered (keys must implement Comparable interface)
* LinkedHashMap: O(1) lookup and insertion and keys are ordered by their insertion order

Reflection: way to get reflective information

Comparable interface:
* `compareTo(T t)` => -1 is smaller than t etc. 

Stream:
* Reduce: ```.reduce(0, (a, b) -> a + b); // 0, assocative function```

### API

* void Arrays.sort([])
* Arrays to List: Arrays.asList(Integer[]) (not a primitive)
* for(int i=0, j=0, i<5; i++, j++)
* boolean instead of int if possible
* LinkedList benefit: add or remove item from the beginnin in constant time
* Set.toArray()
* Sub array: Arrays.copyOfRange(array, start, end)
* String.isEmpty()
* java.util.BitSet (bit manipulation structure<)
* Map iteration: `for (Map.Entry<String, String> entry : map.entrySet()) { entry.getKey(); entry.getValue(); }`

### Size

* byte: 1 byte
* short: 2 bytes (32767)
* int: 4 bytes (2M)
* long: 8 bytes
* float: 4 bytes
* double: 8 bytes
* char: 2 bytes
* boolean: not defined (let's assume 1 byte)

## Big O

* Big O: upper bound
* Big Omega: lower bound (fastest)
* Big Theta: Theta(N) if both O(N) and Omega(N)

* 2^p = Q <=> log Q = P
* O(2^log n) = O(n)
* Square root: √

* O(2n) = O(n)
* O(n² + n) = O(n²)
* O(n + log N) = O(n)
* O(x + 2x + 3x + ... + nx) = O(n²x)

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

Arrays max size: Integer.MAX_VALUE

Java:
* String.charAt(i)
* String.toCharArray()
* String.substring(begin, end) with begin inclusive and end exclusive
* StringBuilder with initial capacity
* StringBuilder.append(String)

Encoding:
* Ascii: 127 characters (1 byte)
* Unicode: superset of ASCII with 2^21 characters
* UTF-8: encoding (not a character set like ascii or unicode, encoding is the translation of a list of characters in binary)

ArrayList Java:
* remove(index):
    * Average complexity is O(n)
    * **Removing the latest element is O(1)**
    * Worst complexity is O(n) if we remove the first element
* get(index)
* set(index, n)
* add(index, n)

## Linked list

A linked list can be single or doubly (reference to the previous and the next)

Runner technique: second pointer moving slower or faster than the first one.
E.g. a second pointer moving to 2 elements instead of 1

**How to get the middle? Using the runner technique with a fast pointer moving 2 and a slow moving one**

* Insert cost: head or tail O(1) otherwise O(n)
* Delete cost: head or tail O(1) otherwise O(n)
* Search cost: O(n)

### Interview

Make sure to ask during the interview whether it is a single or a doubly list

If you're having trouble solving a liked list problem, you should explore if a recursive approach will work

## Hash table

Hash function + linked lists

## Stacks and Queues

* Stack: LIFO (books) => Stack
* Queue: FIFO (waiting line) => LinkedList

Stack are useful with recursivity

Both can be implemented using a linked list

Stack & queue: not constant access to the ith item but constant access with add and remove

Stack:
* push(item)
* pop() // Read and remove an element
* peek() // Read only
* isEmpty()

Queue:
* add(item)
* poll() (return null if empty compared to remove() which return an exception)
* peek()
* isEmpty()

Dequeue Java implem: ArrayDequeue
* addFirst/last()
* pollFirst/last()
* peekFirst/last()

## Trees and Graphs

### Binary tree

* Binary tree: tree with each node has up to two children
* Balanced binary tree: the depth of the two subtrees of every node never differ by more than 1 (also called AVL)
* Complete binary tree: every level of the tree is fully filled (with last level filled from the left to the right)

Complete binary tree:
```
   1
  / \
 2
```

Not complete binary tree:
```
   1
  / \
     2
``` 

* Trie: each node does not store a single character but the full content (```a->b->c``` in a trie gives ```a->ab->abc```). Usually implemented using a map of children.
A trie is used with characters most of the time. 


* Full binary tree: each node has 0 or 2 children
* Perfect binary tree: full and complete (1, 2, 4 etc. nodes)

Binary search tree: 
* Binary tree in which every node must fit the property __all left descendents <= n < all right descendents__
* Delete: find inorder successor and swap them, average O(log n), worst O(h)

Insertion:
```
public TreeNode insert(TreeNode root, int a) {
    if (root == null) {
        return new TreeNode(a);
    }

    if (root.val <= a) { // Left
        root.left = insert(root.left, a);
    } else { // Right
        root.right = insert(root.right, a);
    }

    return root;
}
```

Average complexity of a BST is O(log n) for:
* Insert
* Delete
* Search
* Find min/max

BST > Hash table:
* Sorted keys
* Min/max element

Reverse a binary tree:
```java
public void reverse(Node node) {
    if (node == null) {
        return;
    }

    Node temp = node.right;
    node.right = node.left;
    node.left = temp;

    reverse(node.left);
    reverse(node.right);
}
```

Min-heap: 
* Complete binary tree where each node is smaller than its children
* Insert is started by inserting the element at the bottom (to maintain the complete tree property), then swapping with its parent (O(log n))
* Extract min element: remove the root (min), then swap it with the bottommost/rightmost element, then we try to fix the new root by either swapping it with the left or the right (min of the two children)

### Graph

A tree is just a type of graph

A graph may contain cycle (acyclic graph: without cycles)

Adjacency list:
* Most common way to represent a graph
* Every vertex (or node) stores a list of adjacent verticles

Adjacency matrix:
* N*N boolean matrix (N the number of nodes) where a true at matrix[i][j] means an edge from node i to node j
* Undirected graph (no direction for an edge), an adjacency matrix will be symmetric but it's not necessarily the case with a directed graph

A graph is:
* Dense if the number of edges is close the the maximum possible
* Sparse otherwise

### Search

Graph search:
* Breadth-first (BFS, largeur): start at the root (or any node) and explore each neighbor before going on to any of their children
* Depth-first (DFS, profondeur): explore each branch completely before moving on to the next branch

Binary tree space complexity:
* BFS: O(w), w the max width of the binary tree (max width per level) 
* DFS: O(h), h the max height of the binary tree 

Shortest path: BFS is generally better

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

BFS applied to a tree: level order traversal
```
    1
   / \
  2   3
 / \
4   5
```
=> 1 2 3 4 5

[Implem](./src/io/teivah/tree/BFS.java)

DFS:
* In-order: left-root-right (order)
* Pre-order: root-left-right
* Post-order: left-right-root

In-order traversal:
```java
void traverse(TreeNode node) {
	if(node != null) {
		traverse(node.left);
		visit(node)
		traverse(node.right)
	}
}
```

Pre-order:
```java
void traverse(TreeNode node) {
	if(node != null) {
		visit(node)
		traverse(node.left);
		traverse(node.right)
	}
}
```

Post-order:
```java
void traverse(TreeNode node) {
	if(node != null) {
		traverse(node.left);
		traverse(node.right)
		visit(node)
	}
}
```

Bidirectional search:
* Used to find the shortest path between a source and a destination node
* Two simultaneous bredth-first searches, one from each node

### Java API

Java tree example:
* int getChildCount()
* getChildAt(int)
* TreeNode getParent()
* boolean isLeaf()

Graph API:
* createNode(data)
* addEdge(first, second)

Weaving: merging two arrays in all possible ways while keeping the elements within each array in the same relative order ({1, 2} and {3, 4} never start by 2 for example)
```java
private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
							ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
    if (first.size() == 0 || second.size() == 0) {
        LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
        result.addAll(first);
        result.addAll(second);
        results.add(result);
        return;
    }

    prefix.addLast(first.removeFirst());
    weaveLists(first, second, results, prefix);
    first.addFirst(prefix.removeLast());

    prefix.addLast(second.removeFirst());
    weaveLists(first, second, results, prefix);
    second.addFirst(prefix.removeLast());
}
```

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

XORing a bit with 1 = flip the bit

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

Recursive implementations: at least O(n) memory due to recursive calls

* Memoization: caching results for future calls (top down)
* Dynamic programming: technique for solving problems recursively using tabulation (bottom up) or memoization (top down)

**/!\ Using x and y when dealing with two-dimensional array => m[y][x]**

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

* Don't forget to copy an object in the resulting array (```new ArrayList<>(list)```), the object could be modified by the caller
* Watch out for **recursive functions and loop**! This may be a code smell as the loop should be brought by the recursion itself. 

## Matrix technique

One solution to find longest subsequences or similar problem is to use **a matrix to memorize the previous computations**.

Depending on the context, the value of an element may depends on [i-1][j-1] and/or [i][j-1] and/or [i-1][j]. 

## Sorting and Searching

### Bubble sort

Runtime: O(n²) average and worst case
Memory: O(1)

Swapping pair if first is greater than the second. Start from pair 1, pair 2 etc. until the array is sorted.

### Selection sort

Runtime: O(n²) average and worst case
Memory: O(1)

Find the smallest and swap it with the first element, then the second smallest etc.

### Insertion sort

Algo to arrange a deck of cards (select a card, sort it, select a second card, sort it etc.)

### Merge sort

* **Runtime: O(n log(n)) average and worst case**
* **Memory: O(n)**

Concept:
* Divides input array in two halves
* Falls in the two halves and then merges the two sorted halves

[Implem](./src/io/teivah/sorting/MergeSort.java)

Algorithm:

```
void mergesort(int[] array, int[] helper, int low, int high)
    if low >= high return
    
    mergesort left
    mergesort right
    merge both
        
void merge(int[] array, int[] helper, int low, int middle, int high)```
    copy array into helper from low to high
    left=low, right=middle+1, current=low
    while left<=middle && right <= high
        copy helper from either left or right into array[current] (comparison) 
        increment current and (left or right)
    copy remaining helper from left to middle into array from current position
```

### Quick sort

* **Runtime: O(n log(n)) average, O(n²) worst case**
* **Memory: O(log(n))**

Concept:
* Partition: pick a random element and partition the array such that all numbers that are less than the pivot come before all elements that are greater than it. Partition returns the index of the pivot.
* Sort left
* Sort right

The pivot is not guaranteed to be the median so the sorting could be very slow and be O(n²) worst case.

Algorithm:
```
void quicksort(int[] array, int low, int high)
    // Break condition
    if low >= high return

    // Partition the array according to a pivot
    indexPivot = partition(...)
    quicksort(array, low, indexPivot - 1)
    quicksort(array, indexPivot, high)

int partition(int[] array, int low, int high)
    pivot=array at middle position
    while low <= high
        // Init low and high to make sure that elements before new low are smaller than pivot
        // and elements afer new high are greater than pivot 
        while array[low] < pivot low++
        while array[high] > pivot high++
        if low <= high 
            swap elements low and high from array
            low++, high--
    return low
```

[Implem](./src/io/teivah/sorting/QuickSort.java)

### Radix sort

Runtime: O(kn) where n is the number of elements and k the number of passes of the sorting algorithm

Iteration through each digit of the number (92**0**, 9**2**0 and **9**20), grouping numbers by each digit

## Dynamic

### Min distance algorithm

* Array of a.length() + 1, b.length() + 1
* First row and column initialized with 0..n
* Then:
    * If char match => top left
    * Else => min(left, top left, top) + 1
 
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

## Exercices

### Adding one to an number in an array list

Iterate from the right to the left using a boolean carry (retenue). If at the end carry is true, add 1 to the list at index 0.

### Maximum sub-array of non negative numbers from an array

Iterate over the array with:
* currentSum
* maxSum
* currentArray
* maxArray

Check each time if the max condition is reached

### Pascal triangle

If 0 based (line 1 => i = 0):

`int value = (line+1-i) * res.get(i-1)/i;`

### Wave array (a1 >= a2 <= a3 >= a4)

* Sort the array
* Take indexes 1 0 3 2 5 4 etc. (check if odd, check if last element to not generate an ArrayOutOfBound)

### Max distance in an array with a[i] <= a[j]

* Construct lMin (min from left to right) and rMax (max from right to left)
* Two iterators i on lMin and j on rMax
    * If lMin[i] <= rMax[j]: check if max, increments j
    * Else increments i 
    
### Find the starting and ending position of a given target value in a sorted array

* Search the value in O(log n)
* Search either on the left or on the right in O(log n)

