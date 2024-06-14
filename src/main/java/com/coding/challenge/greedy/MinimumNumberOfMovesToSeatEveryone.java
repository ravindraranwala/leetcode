package com.coding.challenge.greedy;

import com.coding.challenge.radix.sort.RadixSort;

class MinimumNumberOfMovesToSeatEveryone {
	MinimumNumberOfMovesToSeatEveryone() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] seats1 = { 3, 1, 5 };
		final int[] students1 = { 2, 7, 4 };
		assert minMovesToSeat(seats1, students1) == 4;

		final int[] seats2 = { 4, 1, 5, 9 };
		final int[] students2 = { 1, 3, 2, 6 };
		assert minMovesToSeat(seats2, students2) == 7;

		final int[] seats3 = { 2, 2, 6, 6 };
		final int[] students3 = { 1, 3, 2, 6 };
		assert minMovesToSeat(seats3, students3) == 4;
	}

	static int minMovesToSeat(int[] seats, int[] students) {
		final int n = seats.length;
		final int[] sortedSeats = RadixSort.radixSort(seats, 3);
		final int[] sortedStudents = RadixSort.radixSort(students, 3);
		int m = 0;
		for (int i = 0; i < n; i++)
			m = m + Math.abs(sortedSeats[i] - sortedStudents[i]);
		return m;
	}
}
