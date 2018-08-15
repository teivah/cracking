package io.teivah.strings;

import java.util.ArrayList;

public class FullJustify {
	public static void main(String[] args) {
		new FullJustify().main();
	}

	public void main() {
		final ArrayList<String> list = new ArrayList<>();
		list.add("This");
		list.add("is");
		list.add("an");
		list.add("example");
		list.add("of");
		list.add("text");
		list.add("justification.");

		final ArrayList<String> strings = fullJustify(list, 16);

		for (String s : strings) {
			System.out.println(s);
		}
	}

	public ArrayList<String> fullJustify(ArrayList<String> words, int maxWidth) {
		ArrayList<String> result = new ArrayList<String>();

		if (words == null || words.size() == 0) {
			return result;
		}

		int count = 0;
		int last = 0;
		for (int i = 0; i < words.size(); i++) {
			count = count + words.get(i).length();

			if (count + i - last > maxWidth) {
				int wordsLen = count - words.get(i).length();
				int spaceLen = maxWidth - wordsLen;
				int eachLen = 1;
				int extraLen = 0;

				if (i - last - 1 > 0) {
					eachLen = spaceLen / (i - last - 1);
					extraLen = spaceLen % (i - last - 1);
				}

				StringBuilder sb = new StringBuilder();

				for (int k = last; k < i - 1; k++) {
					sb.append(words.get(k));

					int ce = 0;
					while (ce < eachLen) {
						sb.append(" ");
						ce++;
					}

					if (extraLen > 0) {
						sb.append(" ");
						extraLen--;
					}
				}

				sb.append(words.get(i - 1));//last words in the line
				//if only one word in this line, need to fill left with space
				while (sb.length() < maxWidth) {
					sb.append(" ");
				}

				result.add(sb.toString());

				last = i;
				count = words.get(i).length();
			}
		}

		int lastLen = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = last; i < words.size() - 1; i++) {
			count = count + words.get(i).length();
			sb.append(words.get(i) + " ");
		}

		sb.append(words.get(words.size() - 1));
		int d = 0;
		while (sb.length() < maxWidth) {
			sb.append(" ");
		}
		result.add(sb.toString());

		return result;
	}
}
