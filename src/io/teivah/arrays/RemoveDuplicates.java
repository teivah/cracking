package io.teivah.arrays;

import java.util.ArrayList;

public class RemoveDuplicates {
	public static void main(String[] args) {
		new RemoveDuplicates().main();
	}

	public void main() {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5000);
		list.add(5000);
		list.add(5000);
		int n = removeDuplicates(list);
		System.out.println(n);
		System.out.println(list);
	}

	public int removeDuplicates(ArrayList<Integer> a) {
		if (a.size() < 2) return a.size();

		// List#remove is proportional to the number of elements after the removed index
		// Thus, we move from the end for optimal run time
		int prev = a.get(a.size() - 1);
		for (int i = a.size() - 2; i >= 0; i--) {
			if (a.get(i) == prev) {
				a.remove(i);
			} else {
				prev = a.get(i);
			}
		}

		return a.size();
	}

}
