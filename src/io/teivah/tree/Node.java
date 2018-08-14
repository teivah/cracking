package io.teivah.tree;

public class Node {
	public int value;
	public Node left;
	public Node right;

	Node(int value) {
		this.value = value;
		right = null;
		left = null;
	}

	@Override
	public String toString() {
		return string(this);
	}

	public String string(Node n) {
		String s = new Integer(n.value).toString();
		if (n.left != null) {
			s += string(n.left);
		}
		if (n.right != null) {
			s += string(n.right);
		}
		return s;
	}

	public static Node generate1To5() {
		Node root = new Node(1);
		final Node a = new Node(2);
		final Node b = new Node(3);
		root.left = a;
		root.right = b;
		a.left = new Node(4);
		a.right = new Node(5);

		return root;
	}
}
