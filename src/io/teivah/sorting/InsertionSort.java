package io.teivah.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		new InsertionSort().main();
	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return "ListNode{" +
					"val=" + val +
					", next=" + next +
					'}';
		}
	}

	public void main() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(2);

		a.next = b;
		b.next = c;

		final ListNode listNode = insertionSortList(a);
		System.out.println(listNode);
	}

	public ListNode insertionSortList(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		ListNode sorted = A;
		ListNode unsorted = A.next;
		sorted.next = null;
		ListNode next;
		while (unsorted != null) {
			next = unsorted.next;
			sorted = insert(sorted, unsorted);
			unsorted = next;
			;
		}
		return sorted;
	}

	private ListNode insert(ListNode sorted, ListNode unsorted) {
		ListNode it = sorted;
		ListNode prev = null;
		while (it != null && it.val <= unsorted.val) {
			prev = it;
			it = it.next;
		}
		if (prev == null) {
			unsorted.next = it;
			sorted = unsorted;
		} else {
			prev.next = unsorted;
			unsorted.next = it;
		}
		return sorted;
	}
}
