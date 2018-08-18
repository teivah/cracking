package io.teivah.sorting;


public class MergeSortLinkedList {
	public static void main(String[] args) {
		new MergeSortLinkedList().main();
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
		ListNode b = new ListNode(5);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(3);

		a.next = b;
		b.next = c;
		c.next = d;

		final ListNode listNode = sortList(a);
		System.out.println(listNode);
	}

	public ListNode sortList(ListNode list) {
		if (list == null || list.next == null) {
			return list;
		}

		ListNode prev = list;
		ListNode slow = list;
		ListNode fast = list;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		return merge(sortList(list), sortList(slow));
	}

	private ListNode merge(ListNode l, ListNode r) {
		if (l == null) {
			return r;
		}
		if (r == null) {
			return l;
		}

		ListNode sorted;
		if (l.val < r.val) {
			sorted = new ListNode(l.val);
			l = l.next;
		} else {
			sorted = new ListNode(r.val);
			r = r.next;
		}
		ListNode result = sorted;

		while (l != null && r != null) {
			if (l.val < r.val) {
				sorted.next = new ListNode(l.val);
				sorted = sorted.next;
				l = l.next;
			} else {
				sorted.next = new ListNode(r.val);
				sorted = sorted.next;
				r = r.next;
			}
		}

		if (l != null) {
			sorted.next = l;
		}
		if (r != null) {
			sorted.next = r;
		}
		return result;
	}
}
