package com.coding.challenge.binary.search;

class SingleElementInSortedArray {
	SingleElementInSortedArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		assert singleNonDuplicate(numsOne) == 2;

		final int[] numsTwo = { 3, 3, 7, 7, 10, 11, 11 };
		assert singleNonDuplicate(numsTwo) == 10;

		final int[] numsThree = { 1, 1, 2, 3, 3 };
		assert singleNonDuplicate(numsThree) == 2;
	}

	static int singleNonDuplicate(int[] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (j > i) {
			final int m = (i + j) / 2;
			if (nums[m - 1] == nums[m]) {
				if ((m - 1 - i) % 2 == 1)
					j = m - 2;
				else
					i = m + 1;
			} else if (nums[m] == nums[m + 1]) {
				if ((m - i) % 2 == 1)
					j = m - 1;
				else
					i = m + 2;
			} else
				return nums[m];
		}
		return nums[i];
	}
}
