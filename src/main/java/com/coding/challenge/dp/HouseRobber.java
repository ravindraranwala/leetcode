package com.coding.challenge.dp;

class HouseRobber {

	HouseRobber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 1 };
		int w = rob(nums1);
		System.out.println(w);

		final int[] nums2 = { 2, 7, 9, 3, 1 };
		w = rob(nums2);
		System.out.println(w);

		final int[] nums3 = { 2, 7, 9, 8, 1 };
		w = rob(nums3);
		System.out.println(w);

		final int[] nums4 = { 2, 1, 1, 2 };
		w = rob(nums4);
		System.out.println(w);

		final int[] nums5 = { 1, 3, 1, 3, 100 };
		w = rob(nums5);
		System.out.println(w);

		final int[] nums6 = { 6, 3, 10, 8, 2, 10, 3, 5, 10, 5, 3 };
		w = rob(nums6);
		System.out.println(w);
	}

	static int rob(int[] nums) {
		int p1 = 0;
		int p2 = 0;
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			final int tmp = p1 + nums[i];
			p1 = p2;
			p2 = Math.max(tmp, p2);
		}
		return p2;
	}
}
