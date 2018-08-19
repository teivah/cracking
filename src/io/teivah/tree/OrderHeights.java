package io.teivah.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class OrderHeights {
	public static void main(String[] args) {
		new OrderHeights().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final ArrayList<Integer> order = order(arrayList(5, 3, 2, 6, 1, 4), arrayList(0, 1, 2, 0, 3, 2));
		System.out.println(order);
	}

	public ArrayList<Integer> order(ArrayList<Integer> a, ArrayList<Integer> b) {
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			tm.put(a.get(i), b.get(i));
		}

		while (!tm.isEmpty()) {
			int val = tm.lastKey();//gives the maximum element
			if (result.isEmpty()) {
				result.add(val);
				tm.remove(val);//removes the recent added element
			} else {
				int ind = tm.get(val);
				result.add(ind, val);
				tm.remove(val);//removes the recent added element
			}
		}
		return result;
	}
}