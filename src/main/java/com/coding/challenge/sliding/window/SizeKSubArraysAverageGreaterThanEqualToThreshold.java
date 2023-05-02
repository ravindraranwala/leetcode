package com.coding.challenge.sliding.window;

class SizeKSubArraysAverageGreaterThanEqualToThreshold {
	SizeKSubArraysAverageGreaterThanEqualToThreshold() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 2, 2, 2, 2, 5, 5, 5, 8 };
		assert numOfSubarrays(arrOne, 3, 4) == 3;

		final int[] arrTwo = { 11, 13, 17, 23, 29, 31, 7, 5, 2, 3 };
		assert numOfSubarrays(arrTwo, 3, 5) == 6;
	}

	static int numOfSubarrays(int[] arr, int k, int threshold) {
		// Fixed size window.
		final int n = arr.length;
		int c = 0;

		for (int i = 0, s = 0; i < n; i++) {
			s = s + arr[i];
			if (i >= k - 1) {
				final double avg = 1.0 * s / k;
				if (avg >= threshold)
					c = c + 1;
				s = s - arr[i - k + 1];
			}
		}
		return c;
	}
}
