package com.coding.challenge.sliding.window;

import java.util.Arrays;

class KRadiusSubarrayAverages {
	KRadiusSubarrayAverages() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
		final int[] expectedOne = { -1, -1, -1, 5, 4, 4, -1, -1, -1 };
		assert Arrays.equals(getAverages(numsOne, 3), expectedOne);

		final int[] numsTwo = { 100000 };
		final int[] expectedTwo = { 100000 };
		assert Arrays.equals(getAverages(numsTwo, 0), expectedTwo);

		final int[] numsThree = { 8 };
		final int[] expectedThree = { -1 };
		assert Arrays.equals(getAverages(numsThree, 10000), expectedThree);
	}

	static int[] getAverages(int[] nums, int k) {
		// Fixed size window.
		final int n = nums.length;
		final int ws = 2 * k + 1;
		final int[] ans = new int[n];
		long s = 0;

		for (int i = 0; i < n; i++) {
			ans[i] = -1;
			s = s + nums[i];
			if (i >= ws - 1) {
				ans[i - k] = (int) (s / ws);
				s = s - nums[i - ws + 1];
			}
		}
		return ans;
	}
}
