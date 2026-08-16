package com.coding.challenge.greedy;

class MinimizetheMaximumWaitingTimeatSynchronizedTrafficLights {
	MinimizetheMaximumWaitingTimeatSynchronizedTrafficLights() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] lights1 = { 2, 3 };
		final int[] arrivalTime1 = { 2, 5, 8, 11 };
		System.out.println(minPenalty(8, lights1, arrivalTime1));

		final int[] lights2 = { 3, 6, 8 };
		final int[] arrivalTime2 = { 4, 9, 15 };
		System.out.println(minPenalty(10, lights2, arrivalTime2));

		final int[] lights3 = { 2 };
		final int[] arrivalTime3 = { 2, 3, 4, 5, 6 };
		System.out.println(minPenalty(5, lights3, arrivalTime3));
	}

	static int minPenalty(int period, int[] lights, int[] arrivalTime) {
		final int numLights = lights.length;
		int lastOnTime = 0;
		for (int i = 0; i < numLights; i++) {
			if (lights[i] > lastOnTime)
				lastOnTime = lights[i];
		}

		int penalty = 0;
		final int cars = arrivalTime.length;
		for (int i = 0; i < cars; i++) {
			// assign each car to some color light such a way that it minimizes their
			// waiting times.
			final int r = arrivalTime[i] % period;
			if (r >= lastOnTime)
				penalty = Math.max(penalty, period - r);
		}
		return penalty;
	}
}
