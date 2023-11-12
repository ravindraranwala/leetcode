package com.coding.challenge.two.pointer;

class CountSubarraysWithFixedBounds {
	CountSubarraysWithFixedBounds() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 5, 2, 7, 5 };
		assert countSubarrays(numsOne, 1, 5) == 2;

		final int[] numsTwo = { 1, 1, 1, 1 };
		assert countSubarrays(numsTwo, 1, 1) == 10;

		final int[] numsThree = { 35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054,
				109750, 790964, 441974, 552913 };
		assert countSubarrays(numsThree, 35054, 945315) == 81;

		final int[] numsFour = { 4, 1, 1, 3, 5, 5, 1, 4, 1, 3, 5, 7, 5 };
		assert countSubarrays(numsFour, 1, 5) == 39;
	}

	static long countSubarrays(int[] nums, int minK, int maxK) {
		final int n = nums.length;
		long c = 0;
		for (int i = 0, minIdx = -1, maxIdx = -1, startIdx = -1, ans = 0; i < n; i++) {
			if (nums[i] == minK)
				minIdx = i;
			if (nums[i] == maxK)
				maxIdx = i;
			if (nums[i] < minK || nums[i] > maxK)
				startIdx = i;

			if (nums[i] == minK && maxIdx >= 0)
				ans = maxIdx - startIdx;
			else if (nums[i] == maxK && minIdx >= 0)
				ans = minIdx - startIdx;
			if (nums[i] < minK || nums[i] > maxK) {
				ans = 0;
				startIdx = i;
				minIdx = -1;
				maxIdx = -1;
			}
			c = c + ans;
		}
		return c;
	}
}
