package io.teivah.searching;

import java.util.Arrays;
import java.util.List;

public class PivotSortedArray {
	public static void main(String[] args) {
		new PivotSortedArray().main();
	}

	public void main() {
		int n = search(Arrays.asList(4, 5, 6, 7, 0, 1, 2), 5);
		System.out.println(n);
	}

	public int search(final List<Integer> l, int n) {
		if (l == null || l.size() == 0) {
			return -1;
		}

		return search(l, n, 0, l.size() - 1);
	}

	public int search(final List<Integer> l, int n, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;
		int vMid = l.get(mid);

		if (vMid == n) {
			return mid;
		}


		int min = l.get(low);
		if (min == n) {
			return low;
		}

		int max = l.get(high);
		if (max == n) {
			return high;
		}

		if (vMid > min) {
			// If array is sorted on the left
			if (n > min && n < vMid)
				return search(l, n, low, mid - 1);
			else
				return search(l, n, mid + 1, high);
		} else {
			// If array is sorted on the right
			if (n > vMid && n < max)
				return search(l, n, mid + 1, high);
			else
				return search(l, n, low, mid - 1);
		}
	}
}
