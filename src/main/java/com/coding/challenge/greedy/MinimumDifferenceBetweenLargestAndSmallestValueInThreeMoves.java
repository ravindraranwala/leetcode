package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
	MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 3, 2, 4 };
		assert minDifference(nums1) == 0;

		final int[] nums2 = { 1, 5, 0, 10, 14 };
		assert minDifference(nums2) == 1;
	}

	static int minDifference(int[] nums) {
		final int n = nums.length;
		if (n < 5)
			return 0;

		final Queue<Integer> fourLargest = new PriorityQueue<>();
		fourLargest.add(Integer.MIN_VALUE);
		fourLargest.add(Integer.MIN_VALUE);
		fourLargest.add(Integer.MIN_VALUE);
		fourLargest.add(Integer.MIN_VALUE);
		final Queue<Integer> fourSmallest = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		fourSmallest.add(Integer.MAX_VALUE);
		fourSmallest.add(Integer.MAX_VALUE);
		fourSmallest.add(Integer.MAX_VALUE);
		fourSmallest.add(Integer.MAX_VALUE);

		for (int num : nums) {
			if (fourSmallest.peek() > num) {
				fourSmallest.remove();
				fourSmallest.add(num);
			}
			if (fourLargest.peek() < num) {
				fourLargest.remove();
				fourLargest.add(num);
			}
		}

		final int[] largest = new int[4];
		for (int i = 0; i < 4; i++)
			largest[i] = fourLargest.remove();

		int ans = Integer.MAX_VALUE;
		for (int j = 3; j >= 0; j--)
			ans = Math.min(ans, largest[j] - fourSmallest.remove());

		return ans;
	}

	static int minDifferenceNaive(int[] nums) {
		final int n = nums.length;
		if (n < 5)
			return 0;
		Arrays.sort(nums);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= 3; i++)
			ans = Math.min(ans, nums[n - 1 - i] - nums[3 - i]);

		return ans;
	}
}
