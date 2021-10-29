package com.coding.challenge.dp;

class CyclicHouseRobber {

	CyclicHouseRobber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final int[] nums1 = { 2, 3, 2 };
		int w = rob(nums1);
		System.out.println(w);

		// Usecase 2.
		final int[] nums2 = { 1, 2, 3, 1 };
		w = rob(nums2);
		System.out.println(w);

		// Usecase 3.
		final int[] nums3 = { 1, 2, 3 };
		w = rob(nums3);
		System.out.println(w);

		// Usecase 4.
		final int[] nums4 = { 2, 7 };
		w = rob(nums4);
		System.out.println(w);

		final int[] nums5 = { 7 };
		w = rob(nums5);
		System.out.println(w);

		final int[] nums6 = { 1, 2, 1, 1 };
		w = rob(nums6);
		System.out.println(w);
	}

	static int rob(int[] nums) {
		final int n = nums.length;
		if (n == 1)
			return nums[0];
		final int p1 = rob(nums, 0, n - 2);
		final int p2 = rob(nums, 1, n - 1);
		return Math.max(p1, p2);
	}

	static int rob(int[] nums, int s, int e) {
		int p1 = 0;
		int p2 = 0;
		for (int i = s; i <= e; i++) {
			final int tmp = p1 + nums[i];
			p1 = p2;
			p2 = Math.max(tmp, p2);
		}
		return p2;
	}
}
