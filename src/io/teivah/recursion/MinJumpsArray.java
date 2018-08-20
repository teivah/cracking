package io.teivah.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MinJumpsArray {
	public static void main(String[] args) {
		new MinJumpsArray().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final int jump = jump(arrayList(33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28));
		System.out.println(jump);
	}

	public int jump(ArrayList<Integer> l) {
		int n = jump(l, 0, 0, new HashMap<>());
		if (n == Integer.MAX_VALUE) {
			n = -1;
		}
		return n;
	}

	public int jump(ArrayList<Integer> l, int index, int count, HashMap<Integer, Integer> map) {
		if (index == l.size() - 1) {
			return count;
		}

		if (map.containsKey(index)) {
			return Integer.MAX_VALUE;
		}

		int maxJump = l.get(index);
		int minMoves = Integer.MAX_VALUE;
		for (int i = 1; i <= maxJump && index + i < l.size(); i++) {
			int n = jump(l, index + i, count + 1, map);
			if (n < minMoves) {
				minMoves = n;
			} else {
				map.put(index + i, n);
			}

		}

		return minMoves;
	}
}
