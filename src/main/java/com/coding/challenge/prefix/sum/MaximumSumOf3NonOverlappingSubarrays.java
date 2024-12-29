package com.coding.challenge.prefix.sum;

import java.util.Arrays;

class MaximumSumOf3NonOverlappingSubarrays {
	MaximumSumOf3NonOverlappingSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 1, 2, 6, 7, 5, 1 };
		final int[] a1 = { 0, 3, 5 };
		assert Arrays.equals(a1, maxSumOfThreeSubarrays(nums1, 2));

		final int[] nums2 = { 1, 2, 1, 2, 1, 2, 1, 2, 1 };
		final int[] a2 = { 0, 2, 4 };
		assert Arrays.equals(a2, maxSumOfThreeSubarrays(nums2, 2));
	}

	static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		final int n = nums.length;
		final int[] preSum = new int[n];
		preSum[0] = nums[0];
		for (int i = 1; i < n; i++)
			preSum[i] = preSum[i - 1] + nums[i];

		final int[] rightStart = new int[n];
		rightStart[n - k] = n - k;
		for (int s = n - k - 1, rightWindowMaxSum = preSum[n - 1] - preSum[n - k - 1]; s >= k + k; s--) {
			if (preSum[s + k - 1] - preSum[s - 1] >= rightWindowMaxSum) {
				rightStart[s] = s;
				rightWindowMaxSum = preSum[s + k - 1] - preSum[s - 1];
			} else
				rightStart[s] = rightStart[s + 1];
		}

		int ans = 0;
		final int[] a = new int[3];
		for (int i = k, leftWinodwMaxSum = preSum[k - 1], leftWindowEnd = k - 1; i <= n - k - k; i++) {
			final int rightWindowStart = rightStart[i + k];
			final int rightWindowEnd = rightWindowStart + k - 1;
			final int rightWindowSum = preSum[rightWindowEnd] - preSum[rightWindowStart - 1];

			final int midWindowSum = preSum[i + k - 1] - preSum[i - 1];
			if (leftWinodwMaxSum + midWindowSum + rightWindowSum > ans) {
				a[0] = leftWindowEnd - k + 1;
				a[1] = i;
				a[2] = rightWindowStart;
				ans = leftWinodwMaxSum + midWindowSum + rightWindowSum;
			}

			if (preSum[i] - preSum[i - k] > leftWinodwMaxSum) {
				leftWindowEnd = i;
				leftWinodwMaxSum = preSum[i] - preSum[i - k];
			}
		}
		return a;
	}
}
