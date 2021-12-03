package com.coding.challenge.general;

import java.util.HashSet;
import java.util.Set;

public class ContainsDups {
	ContainsDups() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 1 };
		boolean d = containsDuplicate(nums1);
		System.out.println(d);

		final int[] nums2 = { 1, 2, 3, 4 };
		d = containsDuplicate(nums2);
		System.out.println(d);

		final int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
		d = containsDuplicate(nums3);
		System.out.println(d);
	}

	static boolean containsDuplicate(int[] nums) {
		final int n = nums.length;
		final Set<Integer> s = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!s.add(nums[i]))
				return true;
		}
		return false;
	}
}
