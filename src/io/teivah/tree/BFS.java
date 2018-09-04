package io.teivah.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		Queue<Node> queue = new LinkedList<>();
		final Node root = Node.generateSample();
		queue.add(root);
		new BFS().bfs(queue);
	}

	public void bfs(Queue<Node> queue) {
		while (!queue.isEmpty()) {
			final Node node = queue.poll();
			if (node != null) {
				System.out.println(node.value);
				queue.add(node.left);
				queue.add(node.right);
			}
		}
	}
}
