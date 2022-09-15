package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxSubarrayMinProduct {
	MaxSubarrayMinProduct() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3, 2 };
		assert maxSumMinProduct(numsOne) == 14;

		final int[] numsTwo = { 2, 3, 3, 1, 2 };
		assert maxSumMinProduct(numsTwo) == 18;

		final int[] numThree = { 3, 1, 5, 6, 4, 2 };
		assert maxSumMinProduct(numThree) == 60;

		final int[] numsFour = { 5, 10, 6, 10, 4, 2, 1, 4, 5, 2, 4, 2, 7, 5, 8, 6, 3, 6, 6, 4 };
		assert maxSumMinProduct(numsFour) == 156;
	}

	static int maxSumMinProduct(int[] nums) {
		final int n = nums.length;
		final long[] a = new long[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = a[i - 1] + nums[i - 1];

		final Deque<Integer> s = new ArrayDeque<>();
		s.push(0);
		long ans = 0;
		for (int i = 0; i < n; i++) {
			while (s.peek() != 0 && nums[s.peek() - 1] >= nums[i]) {
				final int p = s.pop();
				ans = Math.max(ans, (a[i] - a[s.peek()]) * nums[p - 1]);
			}
			s.push(i + 1);
		}

		// Now we have to take the remaining elements into account.
		while (s.peek() != 0) {
			final int p = s.pop();
			ans = Math.max(ans, (a[n] - a[s.peek()]) * nums[p - 1]);
		}
		return (int) (ans % 1000000007);
	}
}
