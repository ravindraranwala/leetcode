package com.coding.challenge.dp;

class GreatestSumDivisibleByThree {
	GreatestSumDivisibleByThree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 6, 5, 1, 8 };
		assert maxSumDivThree(nums1) == 18;

		final int[] nums2 = { 4 };
		assert maxSumDivThree(nums2) == 0;

		final int[] nums3 = { 1, 2, 3, 4, 4 };
		assert maxSumDivThree(nums3) == 12;

		final int[] nums4 = { 2, 19, 6, 16, 5, 10, 7, 4, 11, 6 };
		assert maxSumDivThree(nums4) == 84;
	}

	static int maxSumDivThree(int[] nums) {
		final int[] s = new int[3];
		final int[] a = new int[3];
		for (int num : nums) {
			final int i = (s[0] + num) % 3;
			a[i] = Math.max(a[i], s[0] + num);
			final int j = (s[1] + num) % 3;
			a[j] = Math.max(a[j], s[1] + num);
			final int k = (s[2] + num) % 3;
			a[k] = Math.max(a[k], s[2] + num);
			s[0] = a[0];
			s[1] = a[1];
			s[2] = a[2];
		}
		return s[0];
	}
}
