package io.teivah.recursion;


import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		new Permutation().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final ArrayList<ArrayList<Integer>> permute = permute(arrayList(1, 2, 3));
		System.out.println(permute);
	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> l) {
		Integer arr[] = l.toArray(new Integer[l.size()]);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		permuteUtil(result, arr, 0);
		return result;
	}

	private void permuteUtil(ArrayList<ArrayList<Integer>> result, Integer arr[], int dist) {
		if (dist == arr.length - 1) {
			result.add(new ArrayList(Arrays.asList(arr)));
		}
		// Permute element by element
		for (int i = dist; i < arr.length; i++) {
			swap(arr, i, dist);
			permuteUtil(result, arr, dist + 1);
			swap(arr, dist, i);
		}
	}

	private void swap(Integer arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
