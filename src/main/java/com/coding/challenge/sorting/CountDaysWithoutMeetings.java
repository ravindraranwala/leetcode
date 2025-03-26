package com.coding.challenge.sorting;

import java.util.Arrays;

class CountDaysWithoutMeetings {
	CountDaysWithoutMeetings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] meetings1 = { { 5, 7 }, { 1, 3 }, { 9, 10 } };
		assert countDays(10, meetings1) == 2;

		final int[][] meetings2 = { { 2, 4 }, { 1, 3 } };
		assert countDays(5, meetings2) == 1;

		final int[][] meetings3 = { { 1, 6 } };
		assert countDays(6, meetings3) == 0;
	}

	static int countDays(int days, int[][] meetings) {
		final int n = meetings.length;
		Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
		int[] last = { 0, -1 };
		int ans = days;
		for (int i = 0; i < n; i++) {
			if (meetings[i][0] > last[1]) {
				ans = ans - last[1] + last[0] - 1;
				last = meetings[i];
			} else if (meetings[i][1] > last[1]) {
				ans = ans - (meetings[i][0] - last[0]);
				last = meetings[i];
			}
		}

		return ans - (last[1] - last[0] + 1);
	}
}
