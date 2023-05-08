package com.coding.challenge.greedy;

class MinDeletionsToMakeArrayBeautiful {
	MinDeletionsToMakeArrayBeautiful() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 2, 3, 5 };
		assert minDeletion(numsOne) == 1;

		final int[] numsTwo = { 1, 1, 2, 2, 3, 3 };
		assert minDeletion(numsTwo) == 2;
	}

	static int minDeletion(int[] nums) {
		final int n = nums.length;
		int d = 0;
		for (int i = 0; i < n - 1; i++)
			if ((i - d) % 2 == 0 && nums[i] == nums[i + 1])
				d = d + 1;

		if ((n - d) % 2 == 1)
			d = d + 1;

		return d;
	}
}
