package io.teivah.recursion;


import java.util.*;

public class TwoSum {
	public static void main(String[] args) {
		new TwoSum().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final ArrayList<Integer> l = twoSum(arrayList(2, 7, 11, 15), 9);
		System.out.println(l);
	}

	public ArrayList<Integer> twoSum(final List<Integer> l, int n) {
		if (l == null || l.size() == 0) {
			return new ArrayList<>();
		}

		final ArrayList<Integer> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < l.size(); i++) {
			int cur = l.get(i);

			if (map.containsKey(n - cur)) {
				int a = map.get(n - cur);
				int b = i;
				res.add(a + 1);
				res.add(b + 1);
				return res;
			}

			if (!map.containsKey(cur)) {
				map.put(cur, i);
			}
		}

		return res;
	}
}
