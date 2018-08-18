package io.teivah.recursion;


import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePermutation {
	public static void main(String[] args) {
		new PalindromePermutation().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final ArrayList<ArrayList<String>> list = partition("aab");
		System.out.println(list);
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		partition(s, 0, new ArrayList<>(), result);
		return result;
	}

	private void partition(String s, int start, ArrayList<String> list, ArrayList<ArrayList<String>> result) {
		if (start >= s.length()) {
			result.add(new ArrayList<>(list));
		}

		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				list.add(s.substring(start, i + 1));
				partition(s, i + 1, list, result);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		int l = start, r = end;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
}
