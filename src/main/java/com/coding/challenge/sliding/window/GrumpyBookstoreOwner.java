package com.coding.challenge.sliding.window;

class GrumpyBookstoreOwner {
	GrumpyBookstoreOwner() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] customersOne = { 1, 0, 1, 2, 1, 1, 7, 5 };
		final int[] grumpyOne = { 0, 1, 0, 1, 0, 1, 0, 1 };
		assert maxSatisfied(customersOne, grumpyOne, 3) == 16;

		final int[] customersTwo = { 1 };
		final int[] grumpyTwo = { 0 };
		assert maxSatisfied(customersTwo, grumpyTwo, 1) == 1;
	}

	static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		final int n = customers.length;
		int s = 0;
		int maxG = 0;

		// fixed size window of length minutes.
		for (int i = 0, g = 0; i < n; i++) {
			if (grumpy[i] == 0)
				s = s + customers[i];
			else
				g = g + customers[i];
			maxG = Math.max(maxG, g);
			if (i >= minutes - 1 && grumpy[i - minutes + 1] == 1)
				g = g - customers[i - minutes + 1];
		}
		return s + maxG;
	}
}
