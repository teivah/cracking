package io.teivah.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FourSum {
	public static void main(String[] args) {
		new FourSum().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final ArrayList<ArrayList<Integer>> l = fourSum(arrayList(1, 0, -1, 0, -2, 2), 0);
		System.out.println(l);
	}

	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> list, int target) {
		Collections.sort(list);
		Integer[] num = new Integer[list.size()];
		num = list.toArray(num);
		HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		// Get each pair
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int left = j + 1;
				int right = num.length - 1;

				// Test if there's a pair with p1 + p2 = target
				// Iterate with two pointers left and right
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];

					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[left]);
						temp.add(num[right]);

						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}

						left++;
						right--;
					}
				}
			}
		}

		return result;
	}
}
