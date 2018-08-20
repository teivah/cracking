package io.teivah.tree;


public class NextPointerBinaryTree {
	public static void main(String[] args) {
		new NextPointerBinaryTree().main();
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			String n;
			if (next != null) {
				n = new Integer(next.val).toString();
			} else {
				n = "null";
			}

			return "TreeLinkNode{" +
					"val=" + val +
					", next=" + n +
					", left=" + left +
					", right=" + right +
					'}';
		}
	}

	public void main() {
		TreeLinkNode a1 = new TreeLinkNode(1);
		TreeLinkNode a2 = new TreeLinkNode(2);
		TreeLinkNode a3 = new TreeLinkNode(3);
		TreeLinkNode a4 = new TreeLinkNode(4);
		TreeLinkNode a5 = new TreeLinkNode(5);
		TreeLinkNode a6 = new TreeLinkNode(6);
		TreeLinkNode a7 = new TreeLinkNode(7);

		a1.left = a2;
		a1.right = a5;
		a2.left = a3;
		a2.right = a4;
		a5.left = a6;
		a5.right = a7;

		connect(a1);
		System.out.println(a1);
	}

	public void connect(TreeLinkNode mostLeft) {
		if (mostLeft == null) {
			return;
		}

		TreeLinkNode parent = null;
		while (mostLeft != null) {
			if (parent == null) {
				mostLeft.next = null;
				parent = mostLeft;
				mostLeft = mostLeft.left;
			} else {
				TreeLinkNode runner = mostLeft;
				while (true) {
					runner.next = parent.right;

					if (parent.next == null) {
						parent.right.next = null;
						parent = mostLeft;
						mostLeft = mostLeft.left;
						break;
					} else {
						parent.right.next = parent.next.left;
						runner = parent.next.left;
						parent = parent.next;
					}
				}
			}
		}
	}

}