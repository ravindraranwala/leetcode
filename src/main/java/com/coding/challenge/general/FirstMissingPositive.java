package com.coding.challenge.general;

class FirstMissingPositive {
	FirstMissingPositive() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 0 };
		assert firstMissingPositive(numsOne) == 3;

		final int[] numsTwo = { 3, 4, -1, 1 };
		assert firstMissingPositive(numsTwo) == 2;

		final int[] numsThree = { 7, 8, 9, 11, 12 };
		assert firstMissingPositive(numsThree) == 1;

		final int[] numsFour = { 2, 4, 7, 5, 6, 4, 7 };
		assert firstMissingPositive(numsFour) == 1;
	}

	static int firstMissingPositive(int[] nums) {
		final int n = nums.length;
		// re-arrange the array first.
		int i = 0;
		while (i < n) {
			// handle dups here to avoid infinite loops.
			if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				// exchange it
				final int tmp = nums[i];
				nums[i] = nums[tmp - 1];
				nums[tmp - 1] = tmp;
			} else
				i = i + 1;
		}
		// now find the answer.
		for (int j = 0; j < n; j++)
			if (nums[j] != j + 1)
				return j + 1;
		return n + 1;
	}
}
