package com.coding.challenge.array;

class CheckIfAll1sAreAtLeastLengthKPlacesAway {
	CheckIfAll1sAreAtLeastLengthKPlacesAway() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 0, 0, 0, 1, 0, 0, 1 };
		assert kLengthApart(nums1, 2);

		final int[] nums2 = { 1, 0, 0, 1, 0, 1 };
		assert !kLengthApart(nums2, 2);
	}

	static boolean kLengthApart(int[] nums, int k) {
		final int n = nums.length;
		for (int i = 0, lastOneIdx = -k - 1; i < n; i++) {
			if (nums[i] == 1) {
				if (i - lastOneIdx - 1 < k)
					return false;

				lastOneIdx = i;
			}
		}
		return true;
	}
}
