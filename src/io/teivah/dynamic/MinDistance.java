package io.teivah.dynamic;


import java.util.ArrayList;
import java.util.Arrays;

public class MinDistance {
	public static void main(String[] args) {
		new MinDistance().main();
	}

	public ArrayList<Integer> arrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final int i = minDistance("Anshuman", "Antihuman");
		System.out.println(i);
	}

	public int minDistance(String a, String b) {
		int[][] tab = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i < a.length() + 1; i++) {
			for (int j = 0; j < b.length() + 1; j++) {
				if (i == 0) {
					tab[i][j] = j;
				} else if (j == 0) {
					tab[i][j] = i;
				} else {

					if (a.charAt(i - 1) == b.charAt(j - 1)) {
						// Top left
						tab[i][j] = tab[i - 1][j - 1];
					} else {
						// Min(left, top left, top) + 1
						tab[i][j] = Math.min(Math.min(tab[i - 1][j], tab[i][j - 1]), tab[i - 1][j - 1]) + 1;
					}
				}
			}
		}

		return tab[a.length()][b.length()];
	}
}
