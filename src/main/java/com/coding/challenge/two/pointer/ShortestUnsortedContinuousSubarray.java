package com.coding.challenge.two.pointer;

class ShortestUnsortedContinuousSubarray {
	ShortestUnsortedContinuousSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 6, 4, 8, 10, 9, 15 };
		assert findUnsortedSubarray(numsOne) == 5;

		final int[] numsTwo = { 1, 2, 3, 4 };
		assert findUnsortedSubarray(numsTwo) == 0;

		final int[] numsThree = { 1 };
		assert findUnsortedSubarray(numsThree) == 0;

		final int[] numsFour = { 4, 6, 2, 8, 10, 9, 15 };
		assert findUnsortedSubarray(numsFour) == 6;

		final int[] numsFive = { 2, 1, 1, 1, 1 };
		assert findUnsortedSubarray(numsFive) == 5;
	}

	static int findUnsortedSubarray(int[] nums) {
		final int n = nums.length;
		final int[] prefixMax = new int[n];
		prefixMax[0] = nums[0];
		final int[] postfixMin = new int[n];
		postfixMin[n - 1] = nums[n - 1];

		for (int i = 1; i < n; i++)
			prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);

		for (int j = n - 2; j >= 0; j--)
			postfixMin[j] = Math.min(postfixMin[j + 1], nums[j]);

		int p = 0;
		while (p < n && prefixMax[p] == postfixMin[p])
			p = p + 1;

		int q = n - 1;
		while (q >= 0 && prefixMax[q] == postfixMin[q])
			q = q - 1;

		return Math.max(q - p + 1, 0);
	}
}
