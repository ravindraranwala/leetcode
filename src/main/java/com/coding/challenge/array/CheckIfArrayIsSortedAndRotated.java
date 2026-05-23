package com.coding.challenge.array;

class CheckIfArrayIsSortedAndRotated {
	CheckIfArrayIsSortedAndRotated() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 4, 5, 1, };
		assert check(nums1);

		final int[] nums2 = { 2, 1, 3, 4 };
		assert !check(nums2);

		final int[] nums3 = { 1, 2, 3 };
		assert check(nums3);

		final int[] nums4 = { 1, 2, 3, 4, 5, 2, 4, 6, 7, 8 };
		assert !check(nums4);

		final int[] nums5 = { 2, 1 };
		assert check(nums5);

		final int[] nums6 = { 5, 5, 5, 5, 1, 2, 3, 4, 5, 5, 5 };
		assert check(nums6);
	}

	static boolean check(int[] nums) {
		final int n = nums.length;
		int cnt = 0;
		for (int i = 1; i < n; i++)
			if (nums[i] < nums[i - 1])
				cnt = cnt + 1;

		if (cnt == 0)
			return true;

		if (cnt > 1)
			return false;

		return nums[0] >= nums[n - 1];
	}
}
