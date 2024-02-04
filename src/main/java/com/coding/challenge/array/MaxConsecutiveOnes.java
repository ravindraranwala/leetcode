package com.coding.challenge.array;

class MaxConsecutiveOnes {
	MaxConsecutiveOnes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 0, 1, 1, 1 };
		System.out.println(findMaxConsecutiveOnes(nums1));

		final int[] nums2 = { 1, 0, 1, 1, 0, 1 };
		System.out.println(findMaxConsecutiveOnes(nums2));
	}

	static int findMaxConsecutiveOnes(int[] nums) {
		final int n = nums.length;
		int l = 0;
		for (int i = 0, j = 0; j < n; j++) {
			if (nums[j] == 0)
				i = j + 1;
			else
				l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
