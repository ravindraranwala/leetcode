package com.coding.challenge.sliding.window;

class ThreeConsecutiveOdds {
	ThreeConsecutiveOdds() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 2, 6, 4, 1 };
		assert !threeConsecutiveOdds(arr1);

		final int[] arr2 = { 1, 2, 34, 3, 4, 5, 7, 23, 1 };
		assert threeConsecutiveOdds(arr2);
	}

	static boolean threeConsecutiveOdds(int[] arr) {
		final int n = arr.length;
		// Fixed size window.
		for (int i = 0, oddCnt = 0; i < n; i++) {
			oddCnt = oddCnt + arr[i] % 2;
			if (i >= 3)
				oddCnt = oddCnt - arr[i - 3] % 2;
			if (oddCnt == 3)
				return true;
		}
		return false;
	}
}
