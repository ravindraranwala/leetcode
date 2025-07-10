package com.coding.challenge.array;

class RescheduleMeetingsForMaximumFreeTimeII {
	RescheduleMeetingsForMaximumFreeTimeII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] startTime1 = { 1, 3 };
		final int[] endTime1 = { 2, 5 };
		assert maxFreeTime(5, startTime1, endTime1) == 2;

		final int[] startTime2 = { 0, 7, 9 };
		final int[] endTime2 = { 1, 8, 10 };
		assert maxFreeTime(10, startTime2, endTime2) == 7;

		final int[] startTime3 = { 0, 3, 7, 9 };
		final int[] endTime3 = { 1, 4, 8, 10 };
		assert maxFreeTime(10, startTime3, endTime3) == 6;
	}

	static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
		final int n = startTime.length;
		int ans = 0;
		for (int i = 0, maxFt = 0, prevEndTime = 0; i < n; i++) {
			final int currFreeTime = startTime[i] - prevEndTime;
			final int duration = endTime[i] - startTime[i];
			int nextStart = eventTime;
			if (i < n - 1)
				nextStart = startTime[i + 1];

			if (duration <= maxFt)
				ans = Math.max(ans, nextStart - prevEndTime);
			else
				ans = Math.max(ans, nextStart - prevEndTime - duration);

			maxFt = Math.max(maxFt, currFreeTime);
			prevEndTime = endTime[i];
		}

		for (int i = n - 1, maxFt = 0, nextStart = eventTime; i >= 0; i--) {
			final int currFreeTime = nextStart - endTime[i];
			final int duration = endTime[i] - startTime[i];
			int prevEndTime = 0;
			if (i > 0)
				prevEndTime = endTime[i - 1];

			if (duration <= maxFt)
				ans = Math.max(ans, nextStart - prevEndTime);
			else
				ans = Math.max(ans, nextStart - prevEndTime - duration);

			maxFt = Math.max(maxFt, currFreeTime);
			nextStart = startTime[i];
		}

		return ans;
	}
}
