package io.teivah;

public class Sandbox {
	public static void main(final String[] args) {
		new Sandbox().main();
	}

	public void main() {
		int[] a = new int[]{1, 4, 10, 0, 0};
		int[] b = new int[]{2, 6};

		merge(a, b);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public void merge(int[] a, int[] b) {
		int i = 0;
		int j = 0;

		while (i < a.length && j < b.length) {
			if (a[i] == 0 && j == b.length) {
				return;
			}

			if (a[i] == 0) {
				a[i++] = b[j];
			} else if (a[i] <= b[j]) {
				i++;
			} else {
				swap(a, b, i, j);
				i++;
			}
		}
	}

	public void swap(int[] a, int[] b, int i, int j) {
		int temp = a[i];
		a[i] = b[j];
		b[j] = temp;
	}
}
