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
		for (int i = 1, l1 = 0, l2 = 1; i < n; i++) {
			if (nums.get(i) > nums.get(i - 1))
				l2 = l2 + 1;
			else {
				l1 = l2;
				l2 = 1;
			}
			if (l2 >= 2 * k)
				return true;
			if (l1 >= k && l2 >= k)
				return true;
		}
		return false;
	}
}
