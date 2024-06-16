package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumIncrementToMakeArrayUnique {

	MinimumIncrementToMakeArrayUnique() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2 };
		assert minIncrementForUnique(nums1) == 1;

		final int[] nums2 = { 3, 2, 1, 2, 1, 7 };
		assert minIncrementForUnique(nums2) == 6;

		final int[] nums3 = { 2, 2, 2, 1 };
		assert minIncrementForUnique(nums3) == 3;

		final int[] nums4 = { 2, 1, 1, 1 };
		assert minIncrementForUnique(nums4) == 5;
	}

	static int minIncrementForUnique(int[] nums) {
		int maxVal = 0;
		for (int e : nums)
			maxVal = Math.max(e, maxVal);
		final int[] f = new int[maxVal + 1];
		for (int e : nums)
			f[e] = f[e] + 1;

		int increments = 0;
		for (int currNum = 0, uniqueCandidate = -1; currNum <= maxVal; currNum++) {
			uniqueCandidate = Math.max(currNum + 1, uniqueCandidate);
			for (int k = 2; k <= f[currNum]; k++) {
				// find the next available number.
				while (uniqueCandidate <= maxVal && f[uniqueCandidate] != 0)
					uniqueCandidate = uniqueCandidate + 1;
				increments = increments + uniqueCandidate - currNum;
				uniqueCandidate = uniqueCandidate + 1;
			}
		}
		return increments;
	}

	static int minIncrementForUniqueSorted(int[] nums) {
		final int n = nums.length;
		Arrays.sort(nums);
		int increments = 0;
		for (int i = 1, uniqueCandidate = 0, j = 0; i < n; i++) {
			// duplicate found !
			if (nums[i] == nums[i - 1]) {
				j = Math.max(j, i + 1);
				uniqueCandidate = Math.max(uniqueCandidate, nums[i] + 1);

				while (j < n && nums[j] <= uniqueCandidate) {
					if (uniqueCandidate == nums[j])
						uniqueCandidate = uniqueCandidate + 1;
					else
						j = j + 1;
				}
				increments = increments + uniqueCandidate - nums[i];
				uniqueCandidate = uniqueCandidate + 1;
			}
		}
		return increments;
	}
}
