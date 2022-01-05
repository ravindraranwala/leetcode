package com.coding.challenge.greedy;

class SplitArrLargestSum {
	SplitArrLargestSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 7, 2, 5, 10, 8 };
		final int m1 = 2;
		int ls = splitArray(nums1, m1);
		System.out.println(ls);

		final int[] nums2 = { 1, 2, 3, 4, 5 };
		final int m2 = 2;
		ls = splitArray(nums2, m2);
		System.out.println(ls);

		final int[] nums3 = { 1, 4, 4 };
		final int m3 = 3;
		ls = splitArray(nums3, m3);
		System.out.println(ls);
	}

	static int splitArray(int[] nums, int m) {
		final int n = nums.length;
		int l = 0;
		int s = 0;
		for (int i = 0; i < n; i++) {
			s = s + nums[i];
			l = Math.max(l, nums[i]);
		}
		int h = (int) Math.ceil((double) n / m) * l;
		l = (int) Math.max(l, Math.ceil((double) s / n));
		int c = 0;
		while (l <= h) {
			final int ls = (l + h) / 2;
			if (possibleSum(nums, ls, m)) {
				h = ls - 1;
				c = ls;
			} else
				l = ls + 1;
		}
		return c;
	}

	static boolean possibleSum(int[] w, int c, int m) {
		final int n = w.length;
		int s = 0;
		for (int i = 0; i < n; i++) {
			if (s + w[i] > c) {
				m = m - 1;
				s = w[i];
			} else
				s = s + w[i];
		}
		m = m - 1;
		return m >= 0;
	}
}
