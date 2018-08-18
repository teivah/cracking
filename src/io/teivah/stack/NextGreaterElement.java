package io.teivah.stack;


import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		new NextGreaterElement().main();
	}

	public void main() {
		int[] a = {4, 5, 2, 3, 10};
		nge(a, a.length);
	}

	static void nge(int arr[], int n) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for (int i = 1; i <= n - 1; i++) {
			while (!stack.isEmpty() && arr[i] > stack.peek()) {
				System.out.println("Pair: " + stack.peek() + ", " + arr[i]);
				stack.pop();
			}
			stack.push(arr[i]);
		}
		while (!stack.isEmpty()) {
			System.out.println("Pair: " + stack.peek() + ", " + -1);
			stack.pop();
		}
	}
}
