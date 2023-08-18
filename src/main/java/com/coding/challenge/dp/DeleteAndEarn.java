package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DeleteAndEarn {
	DeleteAndEarn() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 4, 2 };
		assert deleteAndEarn(numsOne) == 6;

		final int[] numsTwo = { 2, 2, 3, 3, 3, 4 };
		assert deleteAndEarn(numsTwo) == 9;

		final int[] numsThree = { 8, 7, 3, 8, 1, 4, 10, 10, 10, 2 };
		assert deleteAndEarn(numsThree) == 52;

		final int[] numsFour = { 1 };
		assert deleteAndEarn(numsFour) == 1;
	}

	static int deleteAndEarn(int[] nums) {
		final Map<Integer, Integer> t = new HashMap<>();
		// sentinel value.
		t.put(100000, 0);
		for (int val : nums)
			t.merge(val, val, Integer::sum);

		final Integer[] a = t.keySet().toArray(new Integer[0]);
		Arrays.sort(a);
		final int m = a.length;
		int p = 0;
		for (int j = m - 2, prev = 0, beforePrev = 0, curr = 0; j >= 0; j--) {
			// check whether the values are adjacent to each other.
			if (a[j] + 1 == a[j + 1]) {
				curr = Math.max(prev, beforePrev + t.get(a[j]));
			} else
				curr = prev + t.get(a[j]);
			p = Math.max(p, curr);
			beforePrev = prev;
			prev = curr;
		}
		return p;
	}
}
