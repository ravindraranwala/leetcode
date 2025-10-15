package com.coding.challenge.array;

import java.util.Arrays;
import java.util.List;

class AdjacentIncreasingSubarraysDetectionI {
	AdjacentIncreasingSubarraysDetectionI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> nums1 = Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
		assert hasIncreasingSubarrays(nums1, 3);

		final List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
		assert !hasIncreasingSubarrays(nums2, 5);
		
		final List<Integer> nums3 = Arrays.asList(2, 1);
		assert hasIncreasingSubarrays(nums3, 1);
	}

	static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
		final int n = nums.size();
		final boolean[] kIncr = new boolean[n];
		kIncr[0] = k <= 1;
		for (int i = 1, l = 1; i < n; i++) {
			if (nums.get(i) > nums.get(i - 1))
				l = l + 1;
			else
				l = 1;

			if (i >= 2 * k - 1 && l >= k && kIncr[i - 2 * k + 1])
				return true;

			if (l >= k)
				kIncr[i - k + 1] = true;
		}
		return false;
	}
}
