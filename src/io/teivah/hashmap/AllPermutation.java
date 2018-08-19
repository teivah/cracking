package io.teivah.hashmap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllPermutation {
	public static void main(String[] args) {
		new AllPermutation().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final ArrayList<ArrayList<Integer>> permute = permute(arrayList(1, 3, 2));
		System.out.println(permute);
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> l) {
		final ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		if (l == null || l.size() == 0) {
			return result;
		}

		permute(l, result, 0, new HashSet<>());
		return result;
	}

	public void permute(ArrayList<Integer> l, ArrayList<ArrayList<Integer>> result, int index,
						Set<ArrayList<Integer>> set) {
		final ArrayList<Integer> r = new ArrayList<>(l);
		if (!set.contains(r)) {
			result.add(r);
			set.add(r);
		}

		if (index != l.size()) {
			permute(l, result, index + 1, set);
		}

		for (int i = index + 1; i < l.size(); i++) {
			swap(l, index, i);
			permute(l, result, index + 1, set);
			swap(l, index, i);
		}
	}

	public void swap(ArrayList<Integer> l, int a, int b) {
		int temp = l.get(a);
		l.set(a, l.get(b));
		l.set(b, temp);
	}
}