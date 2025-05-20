package com.coding.challenge.prefix.sum;

class ZeroArrayTransformationI {
	ZeroArrayTransformationI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 0, 1 };
		final int[][] queries1 = { { 0, 2 } };
		assert isZeroArray(nums1, queries1);

		final int[] nums2 = { 4, 3, 2, 1 };
		final int[][] queries2 = { { 1, 3 }, { 0, 2 } };
		assert !isZeroArray(nums2, queries2);
	}

	static boolean isZeroArray(int[] nums, int[][] queries) {
		final int n = nums.length;
		final int[] a = new int[n + 1];
		for (int[] q : queries) {
			a[q[0]] = a[q[0]] + 1;
			a[q[1] + 1] = a[q[1] + 1] - 1;
		}

		// doing prefix sum and checking all zero property holds.
		for (int j = 0, s = 0; j < n; j++) {
			s = s + a[j];
			if (nums[j] > s)
				return false;
		}
		return true;
	}
}
