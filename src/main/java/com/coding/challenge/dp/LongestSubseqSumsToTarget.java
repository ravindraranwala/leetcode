package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.List;

class LongestSubseqSumsToTarget {
	LongestSubseqSumsToTarget() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
		assert lengthOfLongestSubsequence(nums1, 9) == 3;

		final List<Integer> nums2 = Arrays.asList(4, 1, 3, 2, 1, 5);
		assert lengthOfLongestSubsequence(nums2, 7) == 4;

		final List<Integer> nums3 = Arrays.asList(1, 1, 5, 4, 5);
		assert lengthOfLongestSubsequence(nums3, 3) == -1;

		final List<Integer> nums4 = Arrays.asList(1, 3, 3, 8);
		assert lengthOfLongestSubsequence(nums4, 7) == 3;
	}

	static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
		final int n = nums.size();
		final int[][] l = new int[target + 1][n + 1];

		for (int i = 1; i <= target; i++) {
			l[i][0] = -1;
			for (int j = 1; j <= n; j++) {
				final int rem = i - nums.get(j - 1);
				// choosing current element leads to some solution. So, try that out.
				if (rem >= 0 && l[rem][j - 1] >= 0)
					l[i][j] = Math.max(l[rem][j - 1] + 1, l[i][j - 1]);
				else
					l[i][j] = l[i][j - 1];
			}
		}

		return l[target][n];
	}
}
