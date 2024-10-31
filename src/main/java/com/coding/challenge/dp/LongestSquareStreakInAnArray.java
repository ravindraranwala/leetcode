package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.radix.sort.RadixSort;

class LongestSquareStreakInAnArray {
	LongestSquareStreakInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 3, 6, 16, 8, 2 };
		assert longestSquareStreak(nums1) == 3;

		final int[] nums2 = { 2, 3, 5, 6, 7 };
		assert longestSquareStreak(nums2) == -1;

		final int[] nums3 = { 4, 16, 256, 65536 };
		assert longestSquareStreak(nums3) == 4;
	}

	static int longestSquareStreakSorted(int[] nums) {
		final int[] a = RadixSort.radixSort(nums, 6);
		int l = -1;
		final int n = nums.length;
		final int[] t = new int[100001];
		final int maxSqrt = (int) Math.sqrt(100000);
		for (int i = n - 1; i >= 0; i--) {
			final int val = a[i];
			t[val] = 1;
			// counter wraps wouldn't hurt us here.
			final int squared = val * val;
			if (val <= maxSqrt && t[squared] > 0) {
				t[val] = t[squared] + 1;
				l = Math.max(l, t[val]);
			}
		}
		return l;
	}

	static int longestSquareStreak(int[] nums) {
		final int[] t = new int[100001];
		int maxVal = 0;
		for (int val : nums) {
			t[val] = 1;
			maxVal = Math.max(val, maxVal);
		}

		int l = -1;
		final int maxSqrt = (int) Math.sqrt(maxVal);
		for (int val = maxSqrt; val > 0; val--) {
			final int squared = val * val;
			if (t[val] != 0 && t[squared] != 0) {
				t[val] = t[squared] + 1;
				l = Math.max(l, t[val]);
			}
		}
		return l;
	}

	static int longestSquareStreakHashTable(int[] nums) {
		// Use a comparison sort for large numbers.
		final int[] a = RadixSort.radixSort(nums, 6);
		final int n = nums.length;
		final Map<Integer, Integer> t = new HashMap<>();
		int l = -1;

		for (int i = n - 1; i >= 0; i--) {
			t.put(a[i], 1);
			final int squaredVal = a[i] * a[i];
			if (t.containsKey(squaredVal)) {
				final int currLen = t.get(squaredVal) + 1;
				t.put(a[i], currLen);
				l = Math.max(l, currLen);
			}
		}
		return l;
	}
}
