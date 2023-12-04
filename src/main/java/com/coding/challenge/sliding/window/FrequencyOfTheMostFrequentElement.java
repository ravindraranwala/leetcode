package com.coding.challenge.sliding.window;

import java.util.Arrays;

class FrequencyOfTheMostFrequentElement {
	FrequencyOfTheMostFrequentElement() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 4 };
		assert maxFrequency(nums1, 5) == 3;

		final int[] nums2 = { 1, 4, 8, 13 };
		assert maxFrequency(nums2, 5) == 2;

		final int[] nums3 = { 3, 9, 6 };
		assert maxFrequency(nums3, 2) == 1;
	}

	static int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		final int n = nums.length;
		int f = 0;
		long ws = 0;
		for (int i = 0, j = 0; j < n; j++) {
			ws = ws + nums[j];
			while (nums[j] * (long) (j - i + 1) - ws > k) {
				ws = ws - nums[i];
				i = i + 1;
			}
			f = Math.max(f, j - i + 1);
		}
		return f;
	}
}
