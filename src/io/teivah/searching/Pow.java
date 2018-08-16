package io.teivah.searching;

public class Pow {
	public static void main(String[] args) {
		new Pow().main();
	}

	public void main() {
		int pow = pow(79161127, 99046373, 57263970);
		System.out.println(pow);
	}

	public int pow(int x, int n, int d) {
		if (n == 0)
			return 1 % d;
		if (n == 1) {
			if (x < 0) {
				return (x + d) % d;
			}
			return x % d;
		}
		long result = 1;
		long prod = x % d;
		long longd = (long) d;
		while (n != 0) {
			int div = n / 2;
			int mod = n % 2;
			if (mod == 1)
				result = (result * prod) % longd;
			n = div;
			prod = (prod * prod) % longd;
		}
		return (int) ((result + d) % d);
	}

}
