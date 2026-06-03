package com.coding.challenge.greedy;

class EarliestFinishTimeForLandandWaterRidesI {
	EarliestFinishTimeForLandandWaterRidesI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] lanrStart1 = { 2, 8 };
		final int[] landDuration1 = { 4, 1 };
		final int[] waterstart1 = { 6 };
		final int[] waterDuration1 = { 3 };
		assert earliestFinishTime(lanrStart1, landDuration1, waterstart1, waterDuration1) == 9;

		final int[] landstart = { 5 };
		final int[] landDuration = { 3 };
		final int[] waterstart = { 1 };
		final int[] waterDuration = { 10 };
		assert earliestFinishTime(landstart, landDuration, waterstart, waterDuration) == 14;
	}

	static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
		final int m = landStartTime.length;
		final int n = waterStartTime.length;
		int landRidesEarliestFinish = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++)
			landRidesEarliestFinish = Math.min(landRidesEarliestFinish, landStartTime[i] + landDuration[i]);

		int waterRidesEarliestFinish = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++)
			waterRidesEarliestFinish = Math.min(waterRidesEarliestFinish, waterStartTime[j] + waterDuration[j]);

		int earliestFinishTime = Integer.MAX_VALUE;
		// water rides followed by land rides.
		for (int i = 0; i < m; i++) {
			if (landStartTime[i] >= waterRidesEarliestFinish)
				earliestFinishTime = Math.min(earliestFinishTime, landStartTime[i] + landDuration[i]);
			else
				earliestFinishTime = Math.min(earliestFinishTime, waterRidesEarliestFinish + landDuration[i]);
		}

		// land rides followed by water rides.
		for (int j = 0; j < n; j++) {
			if (waterStartTime[j] >= landRidesEarliestFinish)
				earliestFinishTime = Math.min(earliestFinishTime, waterStartTime[j] + waterDuration[j]);
			else
				earliestFinishTime = Math.min(earliestFinishTime, landRidesEarliestFinish + waterDuration[j]);
		}
		return earliestFinishTime;
	}
}
