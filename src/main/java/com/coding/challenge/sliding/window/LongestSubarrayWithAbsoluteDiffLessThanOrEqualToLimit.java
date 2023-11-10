package com.coding.challenge.sliding.window;

import java.util.ArrayDeque;
import java.util.Deque;

class LongestSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	LongestSubarrayWithAbsoluteDiffLessThanOrEqualToLimit() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 8, 2, 4, 7 };
		assert longestSubarray(numsOne, 4) == 2;

		final int[] numsTwo = { 10, 1, 2, 4, 7, 2 };
		assert longestSubarray(numsTwo, 5) == 4;

		final int[] numsThree = { 4, 2, 2, 2, 4, 4, 2, 2 };
		assert longestSubarray(numsThree, 0) == 3;
	}

	static int longestSubarray(int[] nums, int limit) {
		final int n = nums.length;
		int l = 1;
		final Deque<Integer> incStack = new ArrayDeque<>();
		final Deque<Integer> decStack = new ArrayDeque<>();
		for (int i = 0, j = 0; j < n; j++) {
			while (!incStack.isEmpty() && nums[incStack.peek()] >= nums[j])
				incStack.pop();
			incStack.push(j);
			while (!decStack.isEmpty() && nums[decStack.peek()] <= nums[j])
				decStack.pop();
			decStack.push(j);
			while (nums[decStack.peekLast()] - nums[incStack.peekLast()] > limit) {
				i = i + 1;
				while (incStack.peekLast() < i)
					incStack.pollLast();
				while (decStack.peekLast() < i)
					decStack.pollLast();
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
