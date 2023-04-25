package com.coding.challenge.general;

class PartitionDisjointIntervals {
	PartitionDisjointIntervals() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 5, 0, 3, 8, 6 };
		assert partitionDisjoint(numsOne) == 3;

		final int[] numsTwo = { 1, 1, 1, 0, 6, 12 };
		assert partitionDisjoint(numsTwo) == 4;

		final int[] numsThree = { 1, 1 };
		assert partitionDisjoint(numsThree) == 1;

		final int[] numsFour = { 32, 57, 24, 19, 0, 24, 49, 67, 87, 87 };
		assert partitionDisjoint(numsFour) == 7;
	}

	static int partitionDisjoint(int[] nums) {
		final int n = nums.length;
		final int[] rightMin = new int[n];
		rightMin[n - 1] = nums[n - 1];

		for (int i = n - 2; i >= 0; i--)
			rightMin[i] = Math.min(rightMin[i + 1], nums[i]);

		for (int i = 0, currMax = nums[i]; i < n - 1; i++) {
			currMax = Math.max(currMax, nums[i]);
			if (currMax <= rightMin[i + 1])
				return i + 1;
		}
		// can't get here.
		throw new AssertionError();
	}
}
