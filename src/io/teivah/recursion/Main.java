package io.teivah.recursion;

public class Main {
	public static int f(final int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return f(n - 1) + f(n - 2);
	}

	public static int f2(final int n, final int[] cache) {
		if (n == 0) return 0;
		if (n == 1) return 1;

		if (cache[n] != 0) {
			return cache[n];
		}

		cache[n] = f2(n - 1, cache) + f2(n - 2, cache);
		return cache[n];
	}

	public static int f3(final int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;

		final int[] cache = new int[n + 1];
		cache[0] = 0;
		cache[1] = 1;

		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}

		return cache[n - 1] + cache[n - 2];
	}

	public static void main(final String[] args) {
		final int n = 10;
//		final int[] cache = new int[n + 1];
		System.out.println("return: " + f3(n));
	}
}
