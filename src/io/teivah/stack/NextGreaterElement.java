package io.teivah.stack;


import java.util.LinkedList;
import java.util.Queue;

public class NextGreaterElement {
	public static void main(String[] args) {
		new NextGreaterElement().main();
	}

	public void main() {
		int[] a = {4, 5, 2, 10, 9};
		nge(a);
	}

	public void nge(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return;
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			int curr = nums[i];
			while (!queue.isEmpty()) {
				if (curr > queue.peek()) {
					print(queue.poll(), curr);
				} else {
					break;
				}
			}

			queue.add(curr);
		}

		while (!queue.isEmpty()) {
			print(queue.poll(), -1);
		}

	}

	void print(int element, int next) {
		System.out.printf("%d -> %d\n", element, next);
	}
}
