package com.coding.challenge.sliding.window;

class GrumpyBookstoreOwner {
	GrumpyBookstoreOwner() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] customers1 = { 1, 0, 1, 2, 1, 1, 7, 5 };
		final int[] grumpy1 = { 0, 1, 0, 1, 0, 1, 0, 1 };
		assert maxSatisfied(customers1, grumpy1, 3) == 16;

		final int[] customers2 = { 1 };
		final int[] grumpy2 = { 0 };
		assert maxSatisfied(customers2, grumpy2, 1) == 1;
	}

	static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		final int n = customers.length;
		int satisfaction = 0;
		// Fixed size window of length minutes.
		int windowMax = 0;
		for (int e = 0, windowSum = 0; e < n; e++) {
			if (grumpy[e] == 1)
				windowSum = windowSum + customers[e];
			else
				satisfaction = satisfaction + customers[e];

			if (e >= minutes && grumpy[e - minutes] == 1)
				windowSum = windowSum - customers[e - minutes];
			windowMax = Math.max(windowMax, windowSum);
		}
		return satisfaction + windowMax;
	}
}
