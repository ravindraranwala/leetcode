package com.coding.challenge.math;

class CheckIfArrayPairsAreDivisibleByk {
	CheckIfArrayPairsAreDivisibleByk() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
		assert canArrange(arr1, 5);

		final int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		assert canArrange(arr2, 7);

		final int[] arr3 = { 1, 2, 3, 4, 5, 6 };
		assert !canArrange(arr3, 10);

		final int[] arr4 = { -1, 1, -2, 2, -3, 3, -4, 4 };
		assert canArrange(arr4, 3);

		final int[] arr5 = { -1, -1, -1, -1, 2, 2, -2, -2 };
		assert !canArrange(arr5, 3);
	}

	static boolean canArrange(int[] arr, int k) {
		final int[] modFreq = new int[k];
		for (int elt : arr) {
			final int currEltMod = (elt % k + k) % k;
			modFreq[currEltMod] = modFreq[currEltMod] + 1;
		}

		final int l = k / 2;
		for (int i = 1; i <= l; i++)
			if (modFreq[i] != modFreq[k - i])
				return false;

		return modFreq[0] % 2 == 0;
	}
}
