package io.teivah.tree;

public class DFS {
	public static void main(String[] args) {
		final Node root = Node.generateSample();
		new DFS().inOrder(root);
		System.out.println("--");
		new DFS().preOrder(root);
		System.out.println("--");
		new DFS().postOrder(root);
	}

	public void inOrder(Node n) {
		if (n == null) {
			return;
		}

		inOrder(n.left);
		System.out.println(n.value);
		inOrder(n.right);
	}

	public void preOrder(Node n) {
		if (n == null) {
			return;
		}

		System.out.println(n.value);
		preOrder(n.left);
		preOrder(n.right);
	}

	public void postOrder(Node n) {
		if (n == null) {
			return;
		}

		postOrder(n.left);
		postOrder(n.right);
		System.out.println(n.value);
	}
}
