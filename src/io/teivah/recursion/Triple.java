package io.teivah.recursion;

import java.util.HashMap;
import java.util.Map;

public class Triple {

	static int f(double remaining, Map<Double, Integer> m) {
		if (remaining == 0) {
			return 1;
		}

		if (remaining < 0) {
			return 0;
		}

		if (m.containsKey(remaining)) {
			return m.get(remaining);
		}

		int n = 0;

		n += f(remaining - 0.25, m);

		n += f(remaining - 0.10, m);

		n += f(remaining - 0.05, m);

		n += f(remaining - 0.01, m);

		m.put(remaining, n);

		return n;
	}

	public static void main(final String[] args) {
		long start = System.nanoTime();
		int n = f(0.50, new HashMap<>());
		long end = System.nanoTime();
		System.out.println(n + " " + (end - start) / 1000 / 1000);
	}
}
