package io.teivah.graphs;

public class Main {
	public static void main(final String[] args) {
		new Main().f();
	}

	public void f() {
		final MinHeapWrapper<Integer> wrapper = new MinHeapWrapper<>();
		wrapper.add(5);
		wrapper.add(4);
		wrapper.add(3);
		System.out.println(wrapper.min());
	}
}
