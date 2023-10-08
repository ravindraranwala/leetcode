package com.coding.challenge.greedy;

import java.util.Arrays;

class AppendK_IntegersWithMinimalSum {
	AppendK_IntegersWithMinimalSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 4, 25, 10, 25 };
		assert minimalKSum(numsOne, 2) == 5;

		final int[] numsTwo = { 5, 6 };
		assert minimalKSum(numsTwo, 6) == 25;
	}

	static long minimalKSum(int[] nums, int k) {
		final int n = nums.length;
		Arrays.sort(nums);
		long s = 0;
		for (int i = 0, val = 1; i < n; i++) {
			while (k > 0 && nums[i] > val) {
				s = s + val;
				k = k - 1;
				val = val + 1;
			}
			val = nums[i] + 1;
		}
		for (; k > 0; k--)
			s = s + nums[n - 1] + k;

		return s;
	}
}
