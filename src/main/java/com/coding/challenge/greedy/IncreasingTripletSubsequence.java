package com.coding.challenge.greedy;

class IncreasingTripletSubsequence {
	IncreasingTripletSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3, 4, 5 };
		assert increasingTriplet(numsOne);

		final int[] numsTwo = { 5, 4, 3, 2, 1 };
		assert !increasingTriplet(numsTwo);

		final int[] numsThree = { 2, 1, 5, 0, 4, 6 };
		assert increasingTriplet(numsThree);

		final int[] numsFour = { 4, 5, 2147483647, 1, 2 };
		assert increasingTriplet(numsFour);
	}

	static boolean increasingTriplet(int[] nums) {
		int v1 = Integer.MAX_VALUE;
		int v2 = Integer.MAX_VALUE;
		for (int e : nums) {
			if (e <= v1)
				v1 = e;
			else if (e > v1 && e <= v2)
				v2 = e;
			else if (e > v2)
				return true;
		}
		return false;
	}
}
