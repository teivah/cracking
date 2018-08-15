package io.teivah.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
	public static void main(String[] args) {
		new MergeOverlappingIntervals().main();
	}

	public void main() {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(30, 63));
		intervals.add(new Interval(64, 65));
		intervals.add(new Interval(1, 100));
		final ArrayList<Interval> result = new MergeOverlappingIntervals().merge(intervals);
		System.out.println(result);
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});

		ArrayList<Interval> res = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= end) {
				end = Math.max(intervals.get(i).end, end);
			} else {
				res.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		res.add(new Interval(start, end));

		return res;
	}

	public class Interval {
		int start;
		int end;

		public Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return start + ":" + end;
		}
	}
}
