package io.teivah.tree;


import java.util.ArrayList;

public class SortedListToBst {
	public static void main(String[] args) {
		new SortedListToBst().main();
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode{" +
					"val=" + val +
					", left=" + left +
					", right=" + right +
					'}';
		}
	}

	static class ListNode {
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
		ListNode root = new ListNode(1);
		ListNode a = new ListNode(2);
		root.next = a;
		ListNode b = new ListNode(3);
		a.next = b;
		ListNode c = new ListNode(4);
		b.next = c;

		final TreeNode treeNode = sortedListToBST(root);
		System.out.println(treeNode);
	}

	public TreeNode sortedListToBST(ListNode a) {
		ArrayList<Integer> num = new ArrayList<Integer>();

		while (a != null) {
			num.add(a.val);
			a = a.next;
		}

		return construct(num, 0, num.size() - 1);
	}


	static TreeNode construct(ArrayList<Integer> num, int low, int high) {
		if (low > high) return null;

		int mid = (high + low) / 2;
		TreeNode node = new TreeNode(num.get(mid));
		node.left = construct(num, low, mid - 1);
		node.right = construct(num, mid + 1, high);
		return node;

	}
}
