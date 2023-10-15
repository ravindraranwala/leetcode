package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
		final Deque<Integer> s = new ArrayDeque<>();

		for (int i = 0; i < n - k; i++) {
			while (!s.isEmpty() && s.peek() > nums[i])
				s.pop();
			s.push(nums[i]);
		}

		final int[] a = new int[k];
		for (int i = n - k; i < n; i++) {
			while (!s.isEmpty() && s.peek() > nums[i])
				s.pop();
			s.push(nums[i]);
			a[i - n + k] = s.pollLast();
		}

		return a;
	}
}
