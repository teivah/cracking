package io.teivah.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Weaving {
	public static void main(String[] args) {
		new Weaving().main();
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

		final ArrayList<LinkedList<Integer>> linkedLists = allSequences(root);
		System.out.println(linkedLists);

		// Test weaving
//		final LinkedList<Integer> first = new LinkedList<>();
//		final LinkedList<Integer> second = new LinkedList<>();
//		first.add(1);
//		first.add(2);
//		second.add(3);
//		second.add(4);
//
//		final ArrayList<LinkedList<Integer>> results = new ArrayList<>();
//		weaveLists(first, second, results, new LinkedList<>());
//		System.out.println(results);
	}

	ArrayList<LinkedList<Integer>> allSequences(Node node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();
		if (node == null) {
			result.add(new LinkedList<>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.value);

		// Compute all subsequences in an array list
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

		// Weave them
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved =
						new ArrayList<>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

	private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
							ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		prefix.addLast(first.removeFirst());
		weaveLists(first, second, results, prefix);
		first.addFirst(prefix.removeLast());

		prefix.addLast(second.removeFirst());
		weaveLists(first, second, results, prefix);
		second.addFirst(prefix.removeLast());
	}

}
