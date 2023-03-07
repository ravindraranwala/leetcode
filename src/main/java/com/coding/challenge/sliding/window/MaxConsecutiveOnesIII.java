package com.coding.challenge.sliding.window;

class MaxConsecutiveOnesIII {
	MaxConsecutiveOnesIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		assert longestOnes(numsOne, 2) == 6;

		final int[] numsTwo = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		assert longestOnes(numsTwo, 3) == 10;
	}

	static int longestOnes(int[] nums, int k) {
		final int n = nums.length;
		int l = 0;

		for (int i = 0, j = 0, zeroCnt = 0; j < n; j++) {
			if (nums[j] == 0)
				zeroCnt = zeroCnt + 1;
			while (zeroCnt > k) {
				if (nums[i] == 0)
					zeroCnt = zeroCnt - 1;
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
