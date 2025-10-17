package com.coding.challenge.sliding.window;

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
		for (int p = 0, q = p, r = 1; r < n; r++) {
			if (nums.get(r) <= nums.get(r - 1)) {
				p = q;
				q = r;
			}
			k = Math.max(k, Math.max(Math.min(q - p, r - q + 1), Math.max(q - p, r - q + 1) / 2));
		}
		return k;
	}
}
