package com.coding.challenge.sliding.window;

class MinSizeSubarraySum {

	MinSizeSubarraySum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(7, numsOne));

		final int[] numstWO = { 1, 4, 4 };
		System.out.println(minSubArrayLen(4, numstWO));

		final int[] numsThree = { 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(minSubArrayLen(11, numsThree));
	}

	static int minSubArrayLen(int target, int[] nums) {
		final int n = nums.length;
		int l = n + 1;
		for (int i = 0, j = 0, s = 0; j < n; j++) {
			s = s + nums[j];
			while (s >= target) {
				l = Math.min(l, (j - i + 1));
				s = s - nums[i];
				i = i + 1;
			}
		}
		return l % (n + 1);
	}
}
