package com.coding.challenge.two.pointer;

class TrionicArrayI {
	TrionicArrayI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 5, 4, 2, 6 };
		assert isTrionic(nums1);

		final int[] nums2 = { 2, 1, 3 };
		assert !isTrionic(nums2);

		final int[] nums3 = { 1, 5, 4, 4 };
		assert !isTrionic(nums3);

		final int[] nums4 = { 5, 5, 4, 7 };
		assert !isTrionic(nums4);

		final int[] nums5 = { 8, 7, 6, 10, 11, 5, 4 };
		assert !isTrionic(nums5);
	}

	static boolean isTrionic(int[] nums) {
		final int n = nums.length;
		int s = 1;
		// strictly increasing
		int i = s;
		while (i < n && nums[i] > nums[i - 1])
			i = i + 1;

		// strictly decreasing
		int j = i;
		while (j < n && nums[j] < nums[j - 1])
			j = j + 1;

		// strictly increasing
		int k = j;
		while (k < n && nums[k] > nums[k - 1])
			k = k + 1;

		// each of the three sub arrays should not be empty.
		// we should inspect all the elements of the input sequence in the end.
		return i != s && j != i && k != j && k == n;
	}
}
