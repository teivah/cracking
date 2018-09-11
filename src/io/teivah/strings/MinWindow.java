package io.teivah.strings;


public class MinWindow {
	public static void main(String[] args) {
		new MinWindow().main();
	}

	public void main() {
		final String s = minWindow("ADOBECODEBANC", "ABC");
		System.out.println(s);
	}

	public String minWindow(String s, String t) {
		if (s == null || t == null) return "";
		// total number of character in p to be contained in s
		int countToBeContained = t.length(), minLen = Integer.MAX_VALUE, startIndex = -1;
		// calculate the number of each character to be contained in S
		int[] dict = new int[128];
		for (char c : t.toCharArray()) dict[c]++;

		int fast = 0, slow = 0;
		while (fast < s.length()) {
			// if need to be contained, include it and minus the counter
			if (dict[s.charAt(fast++)]-- > 0)
				countToBeContained--;

			// all included, move the slow pointer to minimize the window
			while (countToBeContained == 0) {
				// current window contains same number of the current character as in t, cannot move forward anymore
				if (dict[s.charAt(slow++)]++ == 0) countToBeContained++;

				// update minLen
				if (fast - slow + 1 < minLen) {
					startIndex = slow - 1;
					minLen = fast - slow + 1;
				}
			}
		}
		return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
	}

}
