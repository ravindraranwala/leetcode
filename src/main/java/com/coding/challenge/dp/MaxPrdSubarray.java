package com.coding.challenge.dp;

class MaxPrdSubarray {

	MaxPrdSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 3, -2, 4 };
		int p = maxProduct(nums1);
		System.out.println(p);

		final int[] nums2 = { -2, 0, -1 };
		p = maxProduct(nums2);
		System.out.println(p);

		final int[] nums3 = { 2, 3, -2, 10 };
		p = maxProduct(nums3);
		System.out.println(p);

		final int[] nums4 = { -2, 0, -1, -4 };
		p = maxProduct(nums4);
		System.out.println(p);

		final int[] nums5 = { 2, 3, -2, 10, -1 };
		p = maxProduct(nums5);
		System.out.println(p);

		final int[] nums6 = { 7 };
		p = maxProduct(nums6);
		System.out.println(p);

		final int[] nums7 = { 2, -5, -2, -4, 3 };
		p = maxProduct(nums7);
		System.out.println(p);

		final int[] nums8 = { -2 };
		p = maxProduct(nums8);
		System.out.println(p);

		final int[] nums9 = { -2, 0, -1, -4, 0, 2 };
		p = maxProduct(nums9);
		System.out.println(p);
	}

	static int maxProduct(int[] nums) {
		final int n = nums.length;
		int mp = nums[0];
		int fp = 1;
		int bp = 1;
		for (int i = 0; i < n; i++) {
			fp = fp * nums[i];
			bp = bp * nums[n - i - 1];
			mp = Math.max(Math.max(mp, nums[i]), Math.max(fp, bp));
			if (fp == 0)
				fp = 1;
			if (bp == 0)
				bp = 1;
		}
		return mp;
	}
}
