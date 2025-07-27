package com.coding.challenge.two.pointer;

class CountHillsAndValleysInAnArray {
	CountHillsAndValleysInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 4, 1, 1, 6, 5 };
		assert countHillValley(nums1) == 3;

		final int[] nums2 = { 6, 6, 5, 5, 4, 1 };
		assert countHillValley(nums2) == 0;
	}

	static int countHillValley(int[] nums) {
		final int n = nums.length;
		int c = 0;
		for (int i = 2, s = 0; i < n; i++) {
			if (nums[i - 1] > nums[s] && nums[i - 1] > nums[i]) {
				c = c + 1;
				s = i - 1;
			} else if (nums[i - 1] < nums[s] && nums[i - 1] < nums[i]) {
				c = c + 1;
				s = i - 1;
			}
		}
		return c;
	}
}
