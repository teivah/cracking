package io.teivah.linkedlist;


public class Reverse {
	public static void main(String[] args) {
		new Reverse().main();
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
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		final ListNode listNode = reverseBetween(a, 2, 4);
		System.out.println(listNode);
	}

	public ListNode reverseBetween(ListNode l, int m, int n) {
		int i = 1;
		ListNode tmp = l, prev = null;
		while (tmp != null) {
			if (i == m) {
				//s1 marks the node before reversal ans s2 marks first node in the list to be reversed
				ListNode s1 = prev, s2 = tmp, curr;
				while (i <= n) {
					curr = tmp;
					tmp = tmp.next;
					curr.next = prev;
					prev = curr;
					i++;
				}
				if (s1 != null) s1.next = prev; //if there are some nodes before list to be reversed
				else l = prev;                  //if there are no nodes before list to be reversed
				s2.next = tmp;
				break;
			} else {
				prev = tmp;
				tmp = tmp.next;
				i++;
			}
		}
		return l;
	}
}
