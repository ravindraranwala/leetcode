package com.coding.challenge.prefix;

import java.util.HashMap;
import java.util.Map;

class MinSubarray {
	MinSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 1, 4, 2 };
		final int p1 = 6;
		int l = minSubarray(nums1, p1);
		System.out.println(l);

		final int[] nums2 = { 6, 3, 5, 2 };
		final int p2 = 9;
		l = minSubarray(nums2, p2);
		System.out.println(l);

		final int[] nums3 = { 1, 2, 3 };
		final int p3 = 3;
		l = minSubarray(nums3, p3);
		System.out.println(l);

		final int[] nums4 = { 1, 2, 3 };
		final int p4 = 7;
		l = minSubarray(nums4, p4);
		System.out.println(l);

		final int[] nums5 = { 1000000000, 1000000000, 1000000000 };
		final int p5 = 3;
		l = minSubarray(nums5, p5);
		System.out.println(l);

		final int[] nums6 = { 1, 2, 2, 1, 3, 5, 2, 2, 1 };
		final int p6 = 5;
		l = minSubarray(nums6, p6);
		System.out.println(l);

		final int[] nums7 = { 1, 2, 3 };
		final int p7 = 5;
		l = minSubarray(nums7, p7);
		System.out.println(l);

		final int[] nums8 = { 4, 4, 2 };
		final int p8 = 7;
		l = minSubarray(nums8, p8);
		System.out.println(l);

		final int[] nums9 = { 4, 5, 8, 5, 4 };
		final int p9 = 7;
		l = minSubarray(nums9, p9);
		System.out.println(l);

		final int[] nums10 = { 26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3 };
		final int p10 = 26;
		l = minSubarray(nums10, p10);
		System.out.println(l);
	}

	static int minSubarray(int[] nums, int p) {
		final int n = nums.length;
		long s = 0;
		for (int i = 0; i < n; i++)
			s = s + nums[i];
		final int r = (int) (s % p);
		s = 0;
		if (r == 0)
			return r;
		final Map<Integer, Integer> m = new HashMap<>();
		m.put(0, 0);
		int l = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			s = s + nums[i];
			final int rem = (int) ((s - r) % p);
			if (m.containsKey(rem))
				l = Math.min(l, i + 1 - m.get(rem));
			m.put((int) (s % p), i + 1);
		}
		if (l == Integer.MAX_VALUE || l == n)
			return -1;
		return l;
	}
}
