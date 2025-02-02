package com.coding.challenge.two.pointer;

class CheckIfArrayIsSortedAndRotated {
	CheckIfArrayIsSortedAndRotated() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 4, 5, 1, 2 };
		assert check(nums1);

		final int[] nums2 = { 2, 1, 3, 4 };
		assert !check(nums2);

		final int[] nums3 = { 1, 2, 3 };
		assert check(nums3);
	}

	static boolean check(int[] nums) {
		final int n = nums.length;
		int i = 1;
		while (i < n && nums[i] >= nums[i - 1])
			i = i + 1;
		
		if (i == n)
			return true;

		int j = n - 2;
		while (j >= 0 && nums[j] <= nums[j + 1])
			j = j - 1;

		return j < i && nums[0] >= nums[n - 1];
	}
}
