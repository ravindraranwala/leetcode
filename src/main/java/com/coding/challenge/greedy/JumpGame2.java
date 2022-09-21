package com.coding.challenge.greedy;

public class JumpGame2 {
	JumpGame2() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] distOne = { 2, 3, 1, 1, 4 };
		assert jump(distOne) == 2;

		final int[] distTwo = { 2, 3, 0, 1, 4 };
		assert jump(distTwo) == 2;

		final int[] distThree = { 0 };
		assert jump(distThree) == 0;

		final int[] distFour = { 1, 4, 0, 0, 0, 0 };
		assert jump(distFour) == 2;

		final int[] distFive = { 1, 1 };
		assert jump(distFive) == 1;

		final int[] distSix = { 2, 0, 8, 0, 3, 4, 7, 5, 6, 1, 0, 0, 5, 9, 7, 5, 3, 6 };
		assert jump(distSix) == 4;
	}

	static int jump(int[] nums) {
		final int n = nums.length;
		if (n == 1)
			return 0;
		int i = 0;
		int j = 0;
		int k = i + 1;
		while (i + nums[i] < n - 1) {
			// position of the optimal solution
			int p = k;
			while (k <= i + nums[i]) {
				if (k + nums[k] >= n - 1 || p + nums[p] < k + nums[k])
					p = k;
				k = k + 1;
			}
			j = j + 1;
			i = p;
		}
		return j + 1;
	}
}
