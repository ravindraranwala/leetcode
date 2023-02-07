package com.coding.challenge.quick.select;

class KthLargestElement {

	KthLargestElement() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { 3, 2, 1, 5, 6, 4 };
		assert findKthLargest(nums, 2) == 5;

		final int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		assert findKthLargest(nums2, 4) == 4;
	}

	static int findKthLargest(int[] nums, int k) {
		final int n = nums.length;
		final int ks = n - k + 1;
		return QuickSelect.randomizedSelect(nums, 0, n - 1, ks);
	}
}
