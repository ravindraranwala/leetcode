package com.coding.challenge.array;

class ThreeConsecutiveOdds {
	ThreeConsecutiveOdds() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 2, 6, 4, 1 };
		assert !threeConsecutiveOdds(arr1);

		final int[] arr2 = { 1, 2, 34, 3, 4, 5, 7, 23, 12 };
		assert threeConsecutiveOdds(arr2);
	}

	static boolean threeConsecutiveOdds(int[] arr) {
		int c = 0;
		for (int val : arr) {
			if (val % 2 == 0)
				c = 0;
			else
				c = c + 1;

			if (c == 3)
				return true;
		}
		return false;
	}
}
