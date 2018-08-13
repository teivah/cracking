package io.teivah.tree;

public class Reverse {
	public static void main(String[] args) {
		new Reverse().main();
	}

	public void main() {
		Node root = new Node(6);
		final Node a = new Node(3);
		final Node b = new Node(4);
		root.left = a;
		root.right = b;
		a.left = new Node(7);
		a.right = new Node(3);
		b.left = new Node(8);
		b.right = new Node(1);

		System.out.println(root);
		reverse(root);
		System.out.println(root);
	}

	public void reverse(Node node) {
		if (node == null) {
			return;
		}

		Node temp = node.right;
		node.right = node.left;
		node.left = temp;

		reverse(node.left);
		reverse(node.right);
	}
}
