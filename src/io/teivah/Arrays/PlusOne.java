package io.teivah.Arrays;

import java.util.ArrayList;

public class PlusOne {
	public class Solution {
		public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
			int i = 0;
			//remove zeroes at the front
			while (i < a.size() - 1 && a.get(i) == 0) {
				a.remove(i);
			}

			int carry = 1;
			int sum;
			for (i = a.size() - 1; i >= 0; i--) {
				sum = a.get(i) + carry;
				a.set(i, sum % 10);
				carry = sum / 10;
				// no need of further processing if carry is zero
				if (carry == 0) {
					break;
				}
			}
			// if carry is still left
			if (carry != 0) {
				a.add(0, carry);
			}
			return a;
		}
	}
}
