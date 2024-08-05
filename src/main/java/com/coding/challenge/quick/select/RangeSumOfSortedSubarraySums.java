package com.coding.challenge.quick.select;

class RangeSumOfSortedSubarraySums {
	private static final int REM = 1000000007;

	RangeSumOfSortedSubarraySums() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { 1, 2, 3, 4 };
		System.out.println(rangeSum(nums, 4, 1, 5));
		
		System.out.println(rangeSum(nums, 4, 3, 4));
		
		System.out.println(rangeSum(nums, 4, 1, 10));
	}

	static int rangeSum(int[] nums, int n, int left, int right) {
		final int m = n * (n + 1) / 2;
		final int[] a = new int[m];
		for (int i = 0, curr = 0; i < n; i++) {
			for (int j = i, s = 0; j < n; j++) {
				s = s + nums[j];
				a[curr] = s;
				curr = curr + 1;
			}
		}
		QuickSelect.randomizedSelect(a, 0, m - 1, right);
		QuickSelect.randomizedSelect(a, 0, right -1, left);
		int sum = 0;
		for (int i = left - 1; i < right; i++)
			sum = (sum + a[i]) % REM;
		return sum;
	}
}
