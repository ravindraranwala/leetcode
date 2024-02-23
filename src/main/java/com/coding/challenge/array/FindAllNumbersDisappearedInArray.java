package com.coding.challenge.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllNumbersDisappearedInArray {
	FindAllNumbersDisappearedInArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
		assert Arrays.asList(5, 6).equals(findDisappearedNumbers(nums1));

		final int[] nums2 = { 1, 1 };
		assert Arrays.asList(2).equals(findDisappearedNumbers(nums2));
	}

	static List<Integer> findDisappearedNumbers(int[] nums) {
		final int n = nums.length;
		final List<Integer> l = new ArrayList<>();
		for (int i = 0; i < n; i++)
			l.add(i + 1);

		for (int num : nums)
			l.set(num - 1, -1);

		int k = -1;
		for (int j = 0; j < n; j++) {
			if (l.get(j) != -1) {
				k = k + 1;
				l.set(k, l.get(j));
			}
		}

		for (int i = n - 1; i > k; i--)
			l.remove(i);

		return l;
	}
}
