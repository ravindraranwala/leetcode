package com.coding.challenge.sliding.window;

class SubArrPrdLessThanK {

	SubArrPrdLessThanK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 10, 5, 2, 6 };
		final int k1 = 100;
		int c = numSubarrayProductLessThanK(nums1, k1);
		System.out.println(c);

		final int[] nums2 = { 1, 2, 3 };
		final int k2 = 0;
		c = numSubarrayProductLessThanK(nums2, k2);
		System.out.println(c);

		final int[] nums3 = { 10, 5, 2, 10 };
		c = numSubarrayProductLessThanK(nums3, k1);
		System.out.println(c);

		final int[] nums4 = { 10, 5, 2, 75 };
		c = numSubarrayProductLessThanK(nums4, k1);
		System.out.println(c);

		final int[] nums5 = { 10, 5, 2, 100 };
		c = numSubarrayProductLessThanK(nums5, k1);
		System.out.println(c);

		final int[] nums6 = { 1, 1, 1 };
		final int k3 = 1;
		c = numSubarrayProductLessThanK(nums6, k3);
		System.out.println(c);
	}

	static int numSubarrayProductLessThanK(int[] nums, int k) {
		int s = 0;
		int c = 0;
		final int n = nums.length;
		int p = 1;
		for (int i = 0; i < n; i++) {
			p = p * nums[i];
			while (k <= p && s <= i) {
				p = p / nums[s];
				s = s + 1;
			}
			c = c + i - s + 1;
		}
		return c;
	}

}
