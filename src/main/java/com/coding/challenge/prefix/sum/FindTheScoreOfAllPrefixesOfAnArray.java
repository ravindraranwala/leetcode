package com.coding.challenge.prefix.sum;

import java.util.Arrays;

class FindTheScoreOfAllPrefixesOfAnArray {
	FindTheScoreOfAllPrefixesOfAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 3, 7, 5, 10 };
		final long[] ans1 = { 4, 10, 24, 36, 56 };
		assert Arrays.equals(ans1, findPrefixScore(nums1));

		final int[] nums2 = { 1, 1, 2, 4, 8, 16 };
		final long[] ans2 = { 2, 4, 8, 16, 32, 64 };
		assert Arrays.equals(ans2, findPrefixScore(nums2));
	}

	static long[] findPrefixScore(int[] nums) {
		final int n = nums.length;
		final long[] ans = new long[n];
		long s = 0;
		for (int i = 0, max = 0; i < n; i++) {
			max = Math.max(max, nums[i]);
			s = s + max + nums[i];
			ans[i] = s;
		}
		return ans;
	}
}
