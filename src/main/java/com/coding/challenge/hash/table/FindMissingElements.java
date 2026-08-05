package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindMissingElements {
	FindMissingElements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 4, 2, 5 };
		assert List.of(3).equals(findMissingElements(nums1));

		final int[] nums2 = { 7, 8, 6, 9 };
		assert findMissingElements(nums2).isEmpty();

		final int[] nums3 = { 5, 1 };
		assert List.of(2, 3, 4).equals(findMissingElements(nums3));
	}

	static List<Integer> findMissingElements(int[] nums) {
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		final Set<Integer> s = new HashSet<>();

		for (int val : nums) {
			smallest = Math.min(smallest, val);
			largest = Math.max(largest, val);
			s.add(val);
		}

		final List<Integer> l = new ArrayList<>();
		for (int v = smallest; v <= largest; v++)
			if (!s.contains(v))
				l.add(v);

		return l;
	}
}
