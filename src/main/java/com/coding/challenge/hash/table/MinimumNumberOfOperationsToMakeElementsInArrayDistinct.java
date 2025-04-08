package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
	MinimumNumberOfOperationsToMakeElementsInArrayDistinct() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4, 2, 3, 3, 5, 7 };
		assert minimumOperations(nums1) == 2;

		final int[] nums2 = { 4, 5, 6, 4, 4 };
		assert minimumOperations(nums2) == 2;

		final int[] nums3 = { 6, 7, 8, 9 };
		assert minimumOperations(nums3) == 0;
	}

	static int minimumOperations(int[] nums) {
		final int n = nums.length;
		final Set<Integer> s = new HashSet<>();
		int i = n - 1;
		while (i >= 0 && !s.contains(nums[i])) {
			s.add(nums[i]);
			i = i - 1;
		}
		int ans = (i + 1) / 3;
		if ((i + 1) % 3 != 0)
			ans = ans + 1;

		return ans;
	}
}
