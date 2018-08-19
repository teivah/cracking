package io.teivah.hashmap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow {
	public static void main(String[] args) {
		new MinWindow().main();
	}

	public void main() {
		final String s = minWindow("BXYXXXXZOOOOOOOOOOOYXZ", "XYZ");
		System.out.println(s);
	}

	public String minWindow(String s, String t) {
		if (t == null || t.length() == 0) {
			return "";
		}

		// Put t in a map
		Set<Character> charSet = new HashSet<>();
		Map<Character, Integer> countMap = new HashMap<>();
		for (Character c : t.toCharArray()) {
			charSet.add(c);
			if (countMap.containsKey(c)) {
				countMap.put(c, countMap.get(c) + 1);
			} else {
				countMap.put(c, 1);
			}
		}
		int start = 0, end = 0;
		int minStart = -1, minLength = Integer.MAX_VALUE;
		while (end < s.length()) {
			char endChar = s.charAt(end);
			if (charSet.contains(endChar)) {
				countMap.put(endChar, countMap.get(endChar) - 1);
			}
			if (satisfies(countMap)) {
				int curLength = end - start + 1;
				if (curLength < minLength) {
					minLength = curLength;
					minStart = start;
				}
				start++;
				char startChar = s.charAt(start - 1);
				if (countMap.containsKey(startChar)) {
					countMap.put(startChar, countMap.get(startChar) + 1);
				}
				while (satisfies(countMap) && start <= end) {
					curLength = end - start + 1;
					if (curLength < minLength) {
						minLength = curLength;
						minStart = start;
					}
					start++;
					startChar = s.charAt(start - 1);
					if (countMap.containsKey(startChar)) {
						countMap.put(startChar, countMap.get(startChar) + 1);
					}
				}
			}
			end++;
		}
		if (minLength == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(minStart, minStart + minLength);
	}

	private boolean satisfies(Map<Character, Integer> countSet) {
		Set<Character> keySet = countSet.keySet();
		for (Character c : keySet) {
			if (countSet.get(c) > 0) {
				return false;
			}
		}
		return true;
	}
}
