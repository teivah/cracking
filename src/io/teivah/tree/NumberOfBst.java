package io.teivah.tree;


import java.util.ArrayList;

public class NumberOfBst {
	public static void main(String[] args) {
		new NumberOfBst().main();
	}

	public void main() {
		final ArrayList<TreeNode> treeNodes = generateTrees(3);
		System.out.println(treeNodes);
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "(" + val + (left == null ? "" : ",l=" + left) + (right == null ? "" : ",r=" + right) + ")";
		}
	}

	public ArrayList<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}

		return helper(1, n);
	}

	public ArrayList<TreeNode> helper(int min, int max) {
		ArrayList<TreeNode> result = new ArrayList<>();
		if (min > max) {
			result.add(null);
			return result;
		}

		for (int i = min; i <= max; i++) {
			ArrayList<TreeNode> ls = helper(min, i - 1);
			ArrayList<TreeNode> rs = helper(i + 1, max);
			for (TreeNode l : ls) {
				for (TreeNode r : rs) {
					TreeNode curr = new TreeNode(i);
					curr.left = l;
					curr.right = r;
					result.add(curr);
				}
			}
		}

		return result;
	}
}
