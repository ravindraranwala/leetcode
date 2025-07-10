package com.coding.challenge.sliding.window;

class RescheduleMeetingsForMaximumFreeTimeI {
	RescheduleMeetingsForMaximumFreeTimeI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] startTime1 = { 1, 3 };
		final int[] endTime1 = { 2, 5 };
		assert maxFreeTime(5, 1, startTime1, endTime1) == 2;

		final int[] startTime2 = { 0, 2, 9 };
		final int[] endTime2 = { 1, 4, 10 };
		assert maxFreeTime(10, 1, startTime2, endTime2) == 6;

		final int[] startTime3 = { 0, 1, 2, 3, 4 };
		final int[] endTime3 = { 1, 2, 3, 4, 5 };
		assert maxFreeTime(5, 2, startTime3, endTime3) == 0;
	}

	static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
		final int n = startTime.length;
		int maxFreeTime = 0;
		for (int i = 0, wSum = 0, beforeFin = 0; i < n; i++) {
			if (i >= k)
				beforeFin = endTime[i - k];
			int afterStart = eventTime;
			if (i < n - 1)
				afterStart = startTime[i + 1];

			wSum = wSum + endTime[i] - startTime[i];
			maxFreeTime = Math.max(maxFreeTime, afterStart - beforeFin - wSum);
			if (i >= k - 1)
				wSum = wSum - endTime[i - k + 1] + startTime[i - k + 1];
		}
		return maxFreeTime;
	}
}
