# Big O

To be reviewed:
* Ex 8
* Ex 9

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

