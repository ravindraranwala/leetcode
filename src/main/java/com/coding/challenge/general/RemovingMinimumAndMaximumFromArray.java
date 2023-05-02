package com.coding.challenge.general;

class RemovingMinimumAndMaximumFromArray {
	RemovingMinimumAndMaximumFromArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 10, 7, 5, 4, 1, 8, 6 };
		assert minimumDeletions(numsOne) == 5;

		final int[] numsTwo = { 0, -4, 19, 1, 8, -2, -3, 5 };
		assert minimumDeletions(numsTwo) == 3;

		final int[] numsThree = { 101 };
		assert minimumDeletions(numsThree) == 1;
	}

	static int minimumDeletions(int[] nums) {
		final int n = nums.length;
		int l = 0;
		int s = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] < nums[s])
				s = i;
			else if (nums[i] > nums[l])
				l = i;
		}

		int p1 = -1;
		int p2 = -1;
		if (s < l) {
			p1 = s;
			p2 = l;
		} else {
			p1 = l;
			p2 = s;
		}
		return Math.min(Math.min(p2 + 1, n - p1), p1 + 1 + n - p2);
	}
}
