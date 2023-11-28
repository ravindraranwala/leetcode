package com.coding.challenge.fenwick.tree;

import java.util.Arrays;

class CountOfSmallerNumbersAfterSelf {
	CountOfSmallerNumbersAfterSelf() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 5, 2, 6, 1 };
		final int[] ansOne = { 2, 1, 1, 0 };
		assert Arrays.equals(ansOne, countSmaller(numsOne));

		final int[] numsTwo = { -1 };
		final int[] ansTwo = { 0 };
		assert Arrays.equals(ansTwo, countSmaller(numsTwo));

		final int[] numsThree = { -1, -1 };
		final int[] ansThree = { 0, 0 };
		assert Arrays.equals(ansThree, countSmaller(numsThree));
	}

	static int[] countSmaller(int[] nums) {
		final BIT tree = new BIT(20002);
		final int n = nums.length;
		final int[] a = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			a[i] = tree.sum(nums[i] + 10000);
			tree.update(nums[i] + 10001, 1);
		}
		return a;
	}
}
