package io.teivah;

public class Sandbox {
	public static void main(final String[] args) {
		new Sandbox().main();
	}

	public void main() {
		System.out.println((7 & 1) > 0);

	}

	int updateBits(final int n, final int m, final int i, final int j) {
		final int allOnes = ~0;
		final int left = allOnes << (j + 1);
		System.out.println(Integer.toBinaryString(left));

		return -1;
	}

	boolean getBit(final int num, final int i) {
		return ((num & (1 << i)) != 0);
	}

	int setBit(final int num, final int i) {
		return num | (1 << i);
	}

	int clearBit(final int num, final int i) {
		final int mask = ~(1 << i);
		return num & mask;
	}

	int clearBitsFromMsbToI(final int num, final int i) {
		final int mask = (1 << i) - 1;
		return num & mask;
	}

	int clearBitsFromITo0(final int num, final int i) {
		final int mask = (-1 << (i + 1));
		return num & mask;
	}

	int updateBit(final int num, final int i, final boolean bit) {
		final int value = bit ? 1 : 0;
		final int mask = ~(1 << i);
		return (num & mask) | (value << i);
	}
}
