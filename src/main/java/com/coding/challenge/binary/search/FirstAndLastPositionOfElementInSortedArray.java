package com.coding.challenge.binary.search;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

class FirstAndLastPositionOfElementInSortedArray {
	FirstAndLastPositionOfElementInSortedArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 5, 7, 7, 8, 8, 10 };
		final int[] expectedOne = { 3, 4 };
		assert Arrays.equals(expectedOne, searchRange(numsOne, 8));

		final int[] numsTwo = { 5, 7, 7, 8, 8, 10 };
		final int[] expectedTwo = { -1, -1 };
		assert Arrays.equals(expectedTwo, searchRange(numsTwo, 6));

		final int[] numsThree = {};
		assert Arrays.equals(expectedTwo, searchRange(numsThree, 0));
	}

	static int[] searchRange(int[] nums, int target) {
		final int n = nums.length;
		if (n == 0)
			return new int[] { -1, -1 };
		final int i = BinarySearch.predecessor(nums, target);
		final int j = BinarySearch.successor(nums, target);
		if ((j - i) > 1)
			return new int[] { i + 1, j - 1 };
		else
			return new int[] { -1, -1 };
	}
}
