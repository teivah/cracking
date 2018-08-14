package io.teivah.sorting;

public class QuickSort {
	public static void quicksort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {
			quicksort(array, left, index - 1);
		}
		if (index < right) {
			quicksort(array, index, right);
		}
	}

	public static int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];
		while (left <= right) {
			while (array[left] < pivot) left++;
			while (array[right] > pivot) right--;

			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void main(String[] args) {
		int[] a = {3, 2, 5, 4, 4, 7, 10, 1, 7, 0, 1, 3, 9, 2, 5};
		quicksort(a, 0, a.length - 1);
		display(a);
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
