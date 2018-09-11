package io.teivah.strings;

public class Permutation {
	public static void main(String[] args) {
		new Permutation().main();
	}

	public void main() {
		String str = "abcd";
		permute(str, 0, str.length() - 1);
	}

	private void permute(String str, int l, int r) {
		if (l == r) {
			System.out.println(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
