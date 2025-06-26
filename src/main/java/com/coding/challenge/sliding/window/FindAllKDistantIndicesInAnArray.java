package com.coding.challenge.sliding.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllKDistantIndicesInAnArray {
	FindAllKDistantIndicesInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 4, 9, 1, 3, 9, 5 };
		final List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		assert l1.equals(findKDistantIndices(nums1, 9, 1));

		final int[] nums2 = { 2, 2, 2, 2, 2 };
		final List<Integer> l2 = Arrays.asList(0, 1, 2, 3, 4);
		assert l2.equals(findKDistantIndices(nums2, 2, 2));
	}

	static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		final int n = nums.length;
		final List<Integer> l = new ArrayList<>();
		for (int i = 0, c = 0; i < n + k; i++) {
			if (i < n && nums[i] == key)
				c = c + 1;
			if (i - 2 * k - 1 >= 0 && nums[i - 2 * k - 1] == key)
				c = c - 1;

			if (c > 0 && i - k >= 0)
				l.add(i - k);
		}
		return l;
	}
}
