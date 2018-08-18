package io.teivah.stack;


import java.util.*;

public class SlidingWindow {
	public static void main(String[] args) {
		new SlidingWindow().main();
	}

	public ArrayList<Integer> toArrayList(Integer... n) {
		return new ArrayList<>(Arrays.asList(n));
	}

	public void main() {
		final ArrayList<Integer> out = slidingMaximum(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7), 3);
		System.out.println(out);
	}

	public ArrayList<Integer> slidingMaximum(final List<Integer> l, int w) {
		ArrayList<Integer> result = new ArrayList<>();
		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < l.size(); i++) {
			if (!dq.isEmpty() && dq.peekFirst() + w == i) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && l.get(dq.peekLast()) < l.get(i)) {
				dq.removeLast();
			}
			dq.addLast(i);

			if (i >= w - 1) {
				result.add(l.get(dq.peekFirst()));
			}
		}

		return result;
	}
}
