package com.coding.challenge.sliding.window;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class SubarraysWithKDifferentInts {
	SubarraysWithKDifferentInts() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 1, 2, 1, 2, 3 };
		assert subarraysWithKDistinct(arrOne, 2) == 7;

		final int[] arrTwo = { 1, 2, 1, 3, 4 };
		assert subarraysWithKDistinct(arrTwo, 3) == 3;

		final int[] arrThree = { 1, 2, 2, 1, 3 };
		assert subarraysWithKDistinct(arrThree, 2) == 6;

		final int[] arrFour = { 2, 2, 2, 2, 1 };
		assert subarraysWithKDistinct(arrFour, 2) == 4;
	}

	static int subarraysWithKDistinct(int[] nums, int k) {
		final int n = nums.length;
		int c = 0;
		final Map<Integer, Queue<Integer>> t = new HashMap<>();

		for (int j = 0, i = 0, f = 0; j < n; j++) {
			if (t.size() < k)
				f = j;

			t.computeIfAbsent(nums[j], unused -> new ArrayDeque<>()).offer(j);

			while (t.size() == k && (j == n - 1 || !t.containsKey(nums[j + 1]))) {
				// sub-arrays with k distinct elements starting at i
				c = c + j - f + 1;
				t.get(nums[i]).poll();
				if (t.get(nums[i]).isEmpty())
					t.remove(nums[i]);
				else
					f = Math.max(f, t.get(nums[i]).peek());
				i = i + 1;
			}
		}
		return c;
	}
}
