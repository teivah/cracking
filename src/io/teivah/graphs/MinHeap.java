package io.teivah.graphs;

public class MinHeap<T extends Comparable> {
	public T data;
	public MinHeap<T> left;
	public MinHeap<T> right;
	public MinHeap<T> parent;

	public MinHeap(final T data) {
		this.data = data;
	}
}

