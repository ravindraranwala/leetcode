package com.coding.challenge.prefix;

import java.util.HashMap;
import java.util.Map;

class SubArrSumDivByK {

	SubArrSumDivByK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 5, 0, -2, -3, 1 };
		final int k1 = 5;
		int c = subarraysDivByK(nums1, k1);
		System.out.println(c);

		final int[] nums2 = { 5 };
		final int k2 = 9;
		c = subarraysDivByK(nums2, k2);
		System.out.println(c);

		final int[] nums3 = { -1, 2, 9 };
		final int k3 = 2;
		c = subarraysDivByK(nums3, k3);
		System.out.println(c);

		final int[] nums4 = { 2, -2, 2, -4 };
		final int k4 = 6;
		c = subarraysDivByK(nums4, k4);
		System.out.println(c);
	}

	static int subarraysDivByK(int[] nums, int k) {
		int sum = 0;
		final Map<Integer, Integer> m = new HashMap<>();
		m.put(0, 1);
		final int n = nums.length;
		int c = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			final int r = (sum % k + k) % k;
			c = c + m.getOrDefault(r, 0);
			m.merge(r, 1, Integer::sum);
		}
		return c;
	}
}
