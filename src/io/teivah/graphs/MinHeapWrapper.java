package io.teivah.graphs;

public class MinHeapWrapper<T extends Comparable> {
	private MinHeap<T> root;

	public MinHeap<T> getRoot() {
		return root;
	}

	public T min() {
		return root == null ? null : root.data;
	}

	public void add(final T item) {
		final MinHeap<T> t = new MinHeap<>(item);

		if (root == null) {
			root = t;
		} else {
			MinHeap<T> node = root;
			MinHeap<T> parent = null;

			while (node != null) {
				parent = node;
				node = node.right;
			}

			parent.right = t;
			t.parent = parent;

			while (t.parent != null) {
				if (t.data.compareTo(t.parent.data) < 0) {
					final MinHeap<T> grandParent = t.parent.parent;
					final MinHeap<T> child = t.right;

					parent.right = child;
					parent.parent = t;

					t.right = parent;
					t.parent = grandParent;

					if (t.parent == null) {
						root = t;
						return;
					}
				} else {
					return;
				}
			}
		}
	}
}
