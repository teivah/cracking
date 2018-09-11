package io.teivah.arrays;


import java.util.ArrayList;
import java.util.Collections;

//import static io.teivah.Util.arrayList;

public class WaveArray {
	public static void main(String[] args) {
		new WaveArray().main();
	}

	public void main() {
//		final ArrayList<Integer> wave = wave(arrayList(5, 1, 3, 2, 4));
//		System.out.println(wave);
	}

	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		if (a.size() == 1) {
			return a;
		}

		Collections.sort(a);

		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			if (i % 2 == 0) {
				if (i == a.size() - 1) {
					res.add(a.get(i));
				} else {
					res.add(a.get(i + 1));
				}
			} else {
				res.add(a.get(i - 1));
			}
		}
		return res;
	}
}
