package io.teivah.stack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Polish {
	public static void main(String[] args) {
		new Polish().main();
	}

	public void main() {
		final int i = evalRPN(new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+")));
		System.out.println(i);
	}

	public int evalRPN(ArrayList<String> a) {
		Stack<Integer> stack = new Stack<>();

		for (String opr : a) {
			if (opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/")) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				switch (opr) {
					case "+":
						int sum = num1 + num2;
						stack.push(sum);
						break;
					case "-":
						int diff = num2 - num1;
						stack.push(diff);
						break;
					case "*":
						int mult = num1 * num2;
						stack.push(mult);
						break;
					case "/":
						int div = num2 / num1;
						stack.push(div);
				}
			} else {
				stack.push(Integer.parseInt(opr));
			}
		}

		return stack.pop();
	}
}
