package com.coding.challenge.array;

import java.util.ArrayList;
import java.util.List;

class MyCalendarI {
	final List<int[]> intervals = new ArrayList<>();

	MyCalendarI() {

	}

	public static void main(String[] args) {
		final MyCalendarI myCalendar = new MyCalendarI();
		assert myCalendar.book(10, 20); 
		assert !myCalendar.book(15, 25);
		assert myCalendar.book(20, 30);
	}

	public boolean book(int start, int end) {
		for (int[] interval : intervals)
			// check for non-overlapping intervals.
			if (!(interval[0] >= end || interval[1] < start))
				return false;

		intervals.add(new int[] { start, end - 1 });
		return true;
	}
}
