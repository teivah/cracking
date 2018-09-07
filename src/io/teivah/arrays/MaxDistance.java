package io.teivah.arrays;


import java.util.Arrays;
import java.util.List;

public class MaxDistance {
	public static void main(String[] args) {
		new MaxDistance().main();
	}

	public void main() {
		final int i = maximumGap(Arrays.asList(3, 5, 4, 2));
		System.out.println(i);
	}

	public int maximumGap(final List<Integer> a) {
		int maxDiff;
		int i, j;
		int n = a.size();

		int[] lMin = new int[n];
		int[] rMax = new int[n];

       /* Construct lMin[] such that lMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
		lMin[0] = a.get(0);
		for (i = 1; i < n; ++i)
			lMin[i] = Math.min(a.get(i), lMin[i - 1]);

        /* Construct rMax[] such that rMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
		rMax[n - 1] = a.get(n - 1);
		for (j = n - 2; j >= 0; --j)
			rMax[j] = Math.max(a.get(j), rMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
            This process is similar to merge() of MergeSort */
		i = 0;
		j = 0;
		maxDiff = 0;
		while (j < n && i < n) {
			if (lMin[i] <= rMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j++;
			} else
				i++;
		}

		return maxDiff;
	}


}
