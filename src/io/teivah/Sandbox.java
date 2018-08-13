package io.teivah;

public class Sandbox {
	public static void main(final String[] args) {
		new Sandbox().main();
	}

	public void main() {
		int a = 5;
		int b = 8;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.printf("%d %d", a, b);
	}
}
