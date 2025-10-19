package com.coding.challenge.array;

import java.util.Arrays;
import java.util.List;

class AdjacentIncreasingSubarraysDetectionII {
	AdjacentIncreasingSubarraysDetectionII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> nums1 = Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
		assert maxIncreasingSubarrays(nums1) == 3;

		final List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
		assert maxIncreasingSubarrays(nums2) == 2;

		final List<Integer> nums3 = Arrays.asList(4, 4, 5, 6, 7);
		assert maxIncreasingSubarrays(nums3) == 2;

		final List<Integer> nums4 = Arrays.asList(4, 4);
		assert maxIncreasingSubarrays(nums4) == 1;
	}

	static int maxIncreasingSubarrays(List<Integer> nums) {
		final int n = nums.size();
		int k = 0;
		for (int i = 1, l1 = 0, l2 = 1; i < n; i++) {
			if (nums.get(i) > nums.get(i - 1))
				l2 = l2 + 1;
			else {
				l1 = l2;
				l2 = 1;
			}
			k = Math.max(k, Math.max(Math.min(l1, l2), l2/ 2));
		}
		return k;
	}
}
