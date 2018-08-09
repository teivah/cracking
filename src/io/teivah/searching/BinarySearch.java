package io.teivah.searching;

public class BinarySearch {
	public static int binarySearch(int[] a, int x) {
		int low = 0;
		int high = a.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] < x) {
				low = mid + 1;
			} else if (a[mid] > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static int binarySearchRecursive(int[] a, int x, int low, int high) {
		if (high < low) return -1;

		int mid = (low + high) / 2;

		if (a[mid] > x) {
			return binarySearchRecursive(a, x, 0, mid - 1);
		} else if (a[mid] < x) {
			return binarySearchRecursive(a, x, mid + 1, high);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 10, 21, 27, 98, 154, 1111, 2549, 3951};

		int i = binarySearch(a, 2);
		System.out.println(i);

		i = binarySearchRecursive(a, 2, 0, a.length - 1);
		System.out.println(i);
	}
}
