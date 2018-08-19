package io.teivah.recursion;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GenerateParenthesis {
	public static void main(String[] args) {
		new GenerateParenthesis().main();
	}

	public void main() {
		final ArrayList<String> strings = generateParenthesis(3);
		System.out.println(strings);
	}

	public ArrayList<String> generateParenthesis(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}

		final Set<String> res = new HashSet<>();
		generate(n, 0, 0, res, "");

		final ArrayList<String> strings = new ArrayList<>(res);

		Collections.sort(strings);

		return strings;
	}

	public void generate(int n, int curOpened, int curClosed, Set<String> result, String s) {
		if (curOpened == n && curClosed == n) {
			result.add(s);
			return;
		}

		if (curOpened < n) {
			generate(n, curOpened + 1, curClosed, result, s + "(");
		}

		if (curClosed < n && curClosed < curOpened) {
			generate(n, curOpened, curClosed + 1, result, s + ")");
		}
	}
}
