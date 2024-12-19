package com.coding.challenge.greedy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class ContinuousSubarrays {
	ContinuousSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 4, 2, 4 };
		assert continuousSubarraysStack(nums1) == 8;

		final int[] nums2 = { 1, 2, 3 };
		assert continuousSubarraysStack(nums2) == 6;
	}

	static long continuousSubarrays(int[] nums) {
		final int n = nums.length;
		final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
		final PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
		long c = 0;
		for (int i = 0, k = -1; i < n; i++) {
			while (!maxHeap.isEmpty() && Math.abs(nums[maxHeap.peek()] - nums[i]) > 2)
				k = Math.max(k, maxHeap.remove());

			while (!minHeap.isEmpty() && Math.abs(nums[minHeap.peek()] - nums[i]) > 2)
				k = Math.max(k, minHeap.remove());

			c = c + i - k;
			maxHeap.add(i);
			minHeap.add(i);
		}
		return c;
	}

	static long continuousSubarraysStack(int[] nums) {
		final int n = nums.length;
		final Deque<Integer> incStack = new ArrayDeque<>();
		final Deque<Integer> decStack = new ArrayDeque<>();
		long c = 0;
		for (int i = 0, k = -1; i < n; i++) {
			while (!decStack.isEmpty() && Math.abs(nums[decStack.peekLast()] - nums[i]) > 2)
				k = Math.max(k, decStack.pollLast());

			while (!incStack.isEmpty() && Math.abs(nums[incStack.peekLast()] - nums[i]) > 2)
				k = Math.max(k, incStack.pollLast());

			c = c + i - k;
			while (!decStack.isEmpty() && nums[decStack.peekFirst()] < nums[i])
				decStack.pollFirst();
			decStack.push(i);

			while (!incStack.isEmpty() && nums[incStack.peekFirst()] > nums[i])
				incStack.pollFirst();
			incStack.push(i);
		}
		return c;
	}
}
