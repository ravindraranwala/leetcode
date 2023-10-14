package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class FindMostCompetitiveSubsequence {
	FindMostCompetitiveSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 5, 2, 6 };
		final int[] expOne = { 2, 6 };
		assert Arrays.equals(expOne, mostCompetitive(numsOne, 2));

		final int[] numsTwo = { 2, 4, 3, 3, 5, 4, 9, 6 };
		final int[] expTwo = { 2, 3, 3, 4 };
		assert Arrays.equals(expTwo, mostCompetitive(numsTwo, 4));

		final int[] numsThree = { 2, 4, 1, 7 };
		assert Arrays.equals(numsThree, mostCompetitive(numsThree, 4));
	}

	static int[] mostCompetitive(int[] nums, int k) {
		final int n = nums.length;
		// min heap.
		final Queue<Integer> h = new PriorityQueue<>(
				(a, b) -> Integer.compare(nums[a], nums[b]) == 0 ? Integer.compare(a, b)
						: Integer.compare(nums[a], nums[b]));

		for (int i = 0; i < n - k; i++)
			h.add(i);

		final int[] s = new int[k];
		for (int j = 0, p = -1; j < k; j++) {
			h.add(n - k + j);
			while (h.peek() <= p)
				h.remove();

			p = h.remove();
			s[j] = nums[p];
		}
		return s;
	}
}
