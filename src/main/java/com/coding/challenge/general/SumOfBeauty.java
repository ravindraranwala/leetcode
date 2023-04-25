package com.coding.challenge.general;

class SumOfBeauty {
	SumOfBeauty() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3 };
		assert sumOfBeauties(numsOne) == 2;

		final int[] numsTwo = { 2, 4, 6, 4 };
		assert sumOfBeauties(numsTwo) == 1;

		final int[] numsThree = { 3, 2, 1 };
		assert sumOfBeauties(numsThree) == 0;
	}

	static int sumOfBeauties(int[] nums) {
		final int n = nums.length;
		final int[] rightMin = new int[n];
		rightMin[n - 1] = nums[n - 1];
		int sum = 0;

		for (int i = n - 2; i >= 0; i--)
			rightMin[i] = Math.min(rightMin[i + 1], nums[i]);

		for (int i = 0, currMax = nums[i]; i < n - 2; i++) {
			currMax = Math.max(currMax, nums[i]);
			if (currMax < nums[i + 1] && nums[i + 1] < rightMin[i + 2])
				sum = sum + 2;
			else if (nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2])
				sum = sum + 1;
		}
		return sum;
	}
}
