package com.coding.challenge.two.pointer;

class RemoveDuplicatesFromSortedArrayII {
	RemoveDuplicatesFromSortedArrayII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 1, 2, 2, 3 };
		assert removeDuplicates(numsOne) == 5;

		final int[] numsTwo = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		assert removeDuplicates(numsTwo) == 7;
	}

	static int removeDuplicates(int[] nums) {
		final int n = nums.length;
		int k = 2;

		for (int i = 2; i < n; i++) {
			if (nums[i] != nums[k - 2]) {
				nums[k] = nums[i];
				k = k + 1;
			}
		}
		return k;
	}
}
