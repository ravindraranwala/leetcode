package com.coding.challenge.dp;

class NumberOfLongestIncreasingSubsequence {
	NumberOfLongestIncreasingSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 5, 4, 7 };
		assert findNumberOfLIS(numsOne) == 2;

		final int[] numsTwo = { 2, 2, 2, 2, 2 };
		assert findNumberOfLIS(numsTwo) == 5;
	}

	static int findNumberOfLIS(int[] nums) {
		final int n = nums.length;
		final int[] l = new int[n];
		final int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = 1;
			c[i] = 1;
		}

		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (l[j] + 1 == l[i])
						c[i] = c[i] + c[j];
					else if (l[j] + 1 > l[i]) {
						l[i] = l[j] + 1;
						c[i] = c[j];
					}
				}
			}
			maxLen = Math.max(maxLen, l[i]);
		}

		int lisCnt = 0;
		for (int i = 0; i < n; i++)
			if (l[i] == maxLen)
				lisCnt = lisCnt + c[i];
		
		return lisCnt;
	}
}
