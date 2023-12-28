package com.coding.challenge.greedy;

class EqualSumArraysWithMinimumNumberOfOperations {
	EqualSumArraysWithMinimumNumberOfOperations() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4, 5, 6 };
		final int[] nums2 = { 1, 1, 2, 2, 2, 2 };
		assert minOperations(nums1, nums2) == 3;

		final int[] nums3 = { 1, 1, 1, 1, 1, 1, 1 };
		final int[] nums4 = { 6 };
		assert minOperations(nums3, nums4) == -1;

		final int[] nums5 = { 6, 6 };
		final int[] nums6 = { 1 };
		assert minOperations(nums5, nums6) == 3;
	}

	static int minOperations(int[] nums1, int[] nums2) {
		final int[] f1 = new int[7];
		int s1 = 0;
		for (int v : nums1) {
			f1[v] = f1[v] + 1;
			s1 = s1 + v;
		}

		final int[] f2 = new int[7];
		int s2 = 0;
		for (int v : nums2) {
			f2[v] = f2[v] + 1;
			s2 = s2 + v;
		}

		int[] smaller = f1;
		int[] larger = f2;
		if (s1 > s2) {
			smaller = f2;
			larger = f1;
		}

		int steps = 0;
		int d = Math.abs(s1 - s2);
		for (int i = 1; i < 6; i++) {
			final int c = (int) Math.ceil(d * 1.0 / (6 - i));
			if (smaller[i] + larger[7 - i] >= c)
				return steps + c;
			else {
				d = d - (smaller[i] + larger[7 - i]) * (6 - i);
				steps = steps + smaller[i] + larger[7 - i];
			}
		}
		return -1;
	}
}
