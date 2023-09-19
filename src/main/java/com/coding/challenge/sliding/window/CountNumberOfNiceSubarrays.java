package com.coding.challenge.sliding.window;

class CountNumberOfNiceSubarrays {
	CountNumberOfNiceSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 2, 1, 1 };
		assert numberOfSubarrays(numsOne, 3) == 2;

		final int[] numsTwo = { 2, 4, 6 };
		assert numberOfSubarrays(numsTwo, 1) == 0;

		final int[] numsThre = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
		assert numberOfSubarrays(numsThre, 2) == 16;
	}

	static int numberOfSubarrays(int[] nums, int k) {
		final int n = nums.length;
		int c = 0;

		for (int i = 0, j = 0, oddCnt = 0, nextOddIdx = -1; j < n; j++) {
			if (nums[j] % 2 == 1)
				oddCnt = oddCnt + 1;
			if (oddCnt == k) {
				// find the next odd elements index.
				int l = j + 1;
				while (l < n && nums[l] % 2 == 0)
					l = l + 1;
				nextOddIdx = l;
			}

			while (oddCnt == k) {
				c = c + nextOddIdx - j;
				if (nums[i] % 2 == 1)
					oddCnt = oddCnt - 1;
				i = i + 1;
			}
		}
		return c;
	}
}
