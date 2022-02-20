package com.coding.challenge.greedy;

import java.util.Arrays;

class MaxEventsAttended {
	MaxEventsAttended() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] events = { { 27, 27 }, { 8, 10 }, { 9, 11 }, { 20, 21 }, { 25, 29 }, { 17, 20 }, { 12, 12 },
				{ 12, 12 }, { 10, 14 }, { 7, 7 }, { 6, 10 }, { 7, 7 }, { 4, 8 }, { 30, 31 }, { 23, 25 }, { 4, 6 },
				{ 17, 17 }, { 13, 14 }, { 6, 9 }, { 13, 14 } };
		Arrays.sort(events,
				(a, b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
		System.out.println(Arrays.deepToString(events));
		System.out.println(events.length);
	}

}
