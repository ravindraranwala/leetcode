package com.coding.challenge.prefix.sum;

import java.util.HashMap;
import java.util.Map;

class SubArrSumEqK {

	SubArrSumEqK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 1 };
		final int k1 = 2;
		int c = subarraySum(nums1, k1);
		System.out.println(c);

		final int[] nums2 = { 1, 2, 3 };
		final int k2 = 3;
		c = subarraySum(nums2, k2);
		System.out.println(c);

		final int[] nums3 = { 5, 6, 7, 8 };
		final int k3 = -1;
		c = subarraySum(nums3, k3);
		System.out.println(c);

		final int[] nums4 = { 1 };
		final int k4 = 0;
		c = subarraySum(nums4, k4);
		System.out.println(c);

		final int[] nums5 = { -1, -1, 1 };
		c = subarraySum(nums5, 0);
		System.out.println(c);

		final int[] nums6 = { 1, 2, 1, 2, 1 };
		c = subarraySum(nums6, 3);
		System.out.println(c);

		final int[] nums7 = { 1, -1, 0 };
		c = subarraySum(nums7, 0);
		System.out.println(c);

		final int[] nums8 = { 1, -1, 0, 0, 0 };
		c = subarraySum(nums8, 0);
		System.out.println(c);
	}

	static int subarraySum(int[] nums, int k) {
		final int n = nums.length;
		final Map<Integer, Integer> m = new HashMap<>();
		m.put(0, 1);
		int sum = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			c = c + m.getOrDefault(sum - k, 0);
			m.merge(sum, 1, Integer::sum);
		}
		return c;
	}
}
