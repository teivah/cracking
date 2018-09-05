package io.teivah.dynamic;


public class Distinct {
	public static void main(String[] args) {
		new Distinct().main();
	}

	public void main() {
		final int i = numDistinct("rabbbit", "rabbit");
		System.out.println(i);
	}

	public int numDistinct(String A, String B) {
		int m = A.length(), n = B.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (j == 0) dp[i][j] = 1;
				else if (i == 0) dp[i][j] = 0;
				else if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				else dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[m][n];
	}
}
