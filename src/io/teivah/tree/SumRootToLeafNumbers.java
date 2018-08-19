package io.teivah.tree;


public class SumRootToLeafNumbers {
	public static void main(String[] args) {
		new SumRootToLeafNumbers().main();
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
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

	public void main() {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		root.left = a;
		root.right = b;

		final int i = sumNumbers(root);
		System.out.println(i);
	}

	public int sumNumbers(TreeNode a) {
		if (a == null)
			return 0;
		int result = (postOrderSum(a, 0)) % 1003;
		return result;

	}

	public int postOrderSum(TreeNode node, int num) {
		int left = 0;
		int right = 0;
		if (node.left == null && node.right == null)
			return (num * 10 + node.val) % 1003;
		if (node.left != null)
			left = postOrderSum(node.left, (num * 10 + node.val) % 1003);

		if (node.right != null)
			right = postOrderSum(node.right, (num * 10 + node.val) % 1003);

		return (right + left) % 1003;
	}
}