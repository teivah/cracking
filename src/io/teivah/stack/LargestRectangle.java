package io.teivah.stack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle {
	public static void main(String[] args) {
		new LargestRectangle().main();
	}

	public ArrayList<Integer> toArrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final int i = largestRectangleArea(toArrayList(2, 1, 5, 6, 2, 3));
		System.out.println(i);
	}

	public int largestRectangleArea(ArrayList<Integer> A) {

		Stack<Integer> st = new Stack<>();
		int curr = 0;
		int area = 0;

		st.push(curr++);

		while (curr < A.size()) {
			while (!st.isEmpty() && (A.get(curr) < A.get(st.peek()))) {  // we found smaller element than TOS
				int tosIndex = st.pop();        // pop the TOS , we are considering it as minimum height and ll find area for it

				// if stack is empty after popping : then no smaller bar on left hand side of TOS , so multiply it with curr
				// index bcz it will cover overall region including left hand side : bcz its a right bound
				area = getArea(A, st, curr, area, tosIndex);
			}

			// if upcoming bar is larger than TOS then push it onto the stack bcz tht means stack elements can expand themselves into
			// this larger bar
			st.push(curr++);

		}

		// corner case is : if stack is not empty that means we hv elements in ascending
		// height of bars into the stack : so just pop elements one by one and calculate area
		// for them : u hv smaller bar below them and consider rightmost smaller bar as 'curr'
		// as ther is no rightmost smaller bar so it cn expand till end
		if (!st.isEmpty()) {
			int t = -1;

			while (!st.isEmpty()) {
				t = st.pop();

				area = getArea(A, st, curr, area, t);
			}

		}

		return area;
	}

	private int getArea(ArrayList<Integer> A, Stack<Integer> st, int curr, int area, int t) {
		if (st.isEmpty()) {
			int width = curr;
			area = Math.max(area, A.get(t) * width);
		} else {
			// if stck is not empty after popping the element means we hv stored smaller bar tht is thr on lhs of it
			// so width would be between rhs smaller bar (curr) - lhs smaller bar (tos now) -1
			int width = curr - st.peek() - 1;
			area = Math.max(area, A.get(t) * width);
		}
		return area;
	}
}
