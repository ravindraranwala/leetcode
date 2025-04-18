package com.coding.challenge.array;

class CountEqualAndDivisiblePairsInAnArray {
	CountEqualAndDivisiblePairsInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 1, 2, 2, 2, 1, 3 };
		assert countPairs(nums1, 2) == 4;

		final int[] nums2 = { 1, 2, 3, 4 };
		assert countPairs(nums2, 1) == 0;
	}

	static int countPairs(int[] nums, int k) {
		final int n = nums.length;
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (nums[i] == nums[j] && (i * j) % k == 0)
					cnt = cnt + 1;

		return cnt;
	}
}
