package io.teivah.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArray {
	public static void main(String[] args) {
		new IntersectionOfSortedArray().main();
	}

	public void main() {
		List<Integer> a = Arrays.asList(1, 2, 3, 3, 4, 5, 6);
		List<Integer> b = Arrays.asList(3, 3, 5);
		final ArrayList<Integer> intersect = intersect(a, b);
		System.out.println(intersect);
	}

	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
		ArrayList<Integer> result = new ArrayList<>();
		if (a == null || a.size() == 0 || b == null || b.size() == 0) {
			return result;
		}

		int iA = 0;
		int iB = 0;
		ArrayList<Integer> res = new ArrayList<>();
		while (iA < a.size() && iB < b.size()) {
			int nA = a.get(iA);
			int nB = b.get(iB);

			if (nA < nB) {
				iA++;
			} else if (nA > nB) {
				iB++;
			} else {
				res.add(nA);
				iA++;
				iB++;
			}
		}
		return res;
	}
}
