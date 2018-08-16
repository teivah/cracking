package io.teivah.bits;

import java.util.Arrays;
import java.util.List;

public class Thrice {
	public static void main(String[] args) {
		new Thrice().main();
	}

	public void main() {
		int n = singleNumber(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1));
	}

	public int singleNumber(final List<Integer> list) {
		int result = 0;

		for (int i = 0; i < 32; i++) {
			int n = 1 << i;

			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if ((list.get(j) & n) != 0) {
					count++;
				}
			}

			if (count % 3 != 0) {
				result |= n;
			}
		}

		return result;
	}
}
