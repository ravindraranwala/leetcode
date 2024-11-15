package com.coding.challenge.binary.search;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

class CountTheNumberOfFairPairs {
	CountTheNumberOfFairPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 0, 1, 7, 4, 4, 5 };
		assert countFairPairs(nums1, 3, 6) == 6;

		final int[] nums2 = { 1, 7, 9, 2, 5 };
		assert countFairPairs(nums2, 11, 11) == 1;
	}

	static long countFairPairsBinSearch(int[] nums, int lower, int upper) {
		final int n = nums.length;
		Arrays.sort(nums);
		long c = 0;
		for (int i = 0; i < n - 1 && nums[i] + nums[i + 1] <= upper; i++) {
			if (nums[i] + nums[n - 1] >= lower) {
				final int j = BinarySearch.successor(nums, lower - nums[i] - 1, i + 1, n - 1);
				final int k = BinarySearch.predecessor(nums, upper - nums[i] + 1, i + 1, n - 1);
				c = c + k - j + 1;
			}
		}
		return c;
	}

	static long countFairPairs(int[] nums, int lower, int upper) {
		final int n = nums.length;
		Arrays.sort(nums);
		long c = 0;
		for (int i = 0, j = n - 1, k = n - 1; i < n - 1 && nums[i] + nums[i + 1] <= upper; i++) {
			if (nums[i] + nums[n - 1] >= lower) {
				final int windMin = lower - nums[i];
				while (j > i && nums[j] >= windMin)
					j = j - 1;

				final int windMax = upper - nums[i];
				while (nums[k] > windMax)
					k = k - 1;

				if (j > i)
					c = c + k - j;
				else
					c = c + k - i;
			}
		}
		return c;
	}
}
