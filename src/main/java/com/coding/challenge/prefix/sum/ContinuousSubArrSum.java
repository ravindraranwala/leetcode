package com.coding.challenge.prefix.sum;

import java.util.HashSet;
import java.util.Set;

class ContinuousSubArrSum {

	ContinuousSubArrSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 23, 2, 4, 6, 7 };
		final int k1 = 6;
		boolean f = checkSubarraySum(nums1, k1);
		System.out.println(f);

		final int[] nums2 = { 23, 2, 6, 4, 7 };
		f = checkSubarraySum(nums2, k1);
		System.out.println(f);

		final int[] nums3 = { 23, 2, 6, 4, 7 };
		final int k2 = 13;
		f = checkSubarraySum(nums3, k2);
		System.out.println(f);

		final int[] nums4 = { 2, 4, 3 };
		f = checkSubarraySum(nums4, k1);
		System.out.println(f);
	}

	static boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
		final int n = nums.length;
		final Set<Integer> s = new HashSet<>();
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
			final int r = sum % k;
			if (s.contains(r))
				return true;
			// Mind the operator precedence here !
			s.add((sum - nums[i]) % k);
		}
		return false;
	}
}
