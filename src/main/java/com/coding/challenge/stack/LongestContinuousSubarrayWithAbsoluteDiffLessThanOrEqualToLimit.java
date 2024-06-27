package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 8, 2, 4, 7 };
		assert longestSubarray(nums1, 4) == 2;

		final int[] nums2 = { 10, 1, 2, 4, 7, 2 };
		assert longestSubarray(nums2, 5) == 4;

		final int[] nums3 = { 4, 2, 2, 2, 4, 4, 2, 2 };
		assert longestSubarray(nums3, 0) == 3;

		final int[] nums4 = { 2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2 };
		assert longestSubarray(nums4, 2) == 6;
	}

	static int longestSubarray(int[] nums, int limit) {
		final int n = nums.length;
		final Deque<Integer> incStack = new ArrayDeque<>();
		final Deque<Integer> decStack = new ArrayDeque<>();
		int l = 0;

		for (int i = 0, lastRemovedIdx = -1; i < n; i++) {
			while (!decStack.isEmpty() && nums[decStack.peekLast()] - nums[i] > limit)
				lastRemovedIdx = decStack.pollLast();
			while (!incStack.isEmpty() && nums[i] - nums[incStack.peekLast()] > limit)
				lastRemovedIdx = incStack.pollLast();

			l = Math.max(l, i - lastRemovedIdx);

			while (!incStack.isEmpty() && nums[incStack.peek()] >= nums[i])
				incStack.poll();
			incStack.push(i);

			while (!decStack.isEmpty() && nums[decStack.peek()] <= nums[i])
				decStack.poll();
			decStack.push(i);
		}
		return l;
	}
}
