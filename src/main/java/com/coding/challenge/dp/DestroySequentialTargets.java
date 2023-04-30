package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

class DestroySequentialTargets {
	DestroySequentialTargets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 7, 8, 1, 1, 5 };
		assert destroyTargets(numsOne, 2) == 1;

		final int[] numsTwo = { 1, 3, 5, 2, 4, 6 };
		assert destroyTargets(numsTwo, 2) == 1;

		final int[] numsThree = { 6, 2, 5 };
		assert destroyTargets(numsThree, 100) == 2;

		final int[] numsFour = { 1, 5, 3, 2, 2 };
		assert destroyTargets(numsFour, 10000) == 2;

		final int[] numsFive = { 625879766, 235326233, 250224393, 501422042, 683823101, 948619719, 680305710, 733191937,
				182186779, 353350082 };
		assert destroyTargets(numsFive, 4) == 235326233;
	}

	static int destroyTargets(int[] nums, int space) {
		final Map<Integer, int[]> t = new HashMap<>();
		int l = 0;
		int seed = 0;

		for (int num : nums) {
			final int r = num % space;
			final int[] v = t.getOrDefault(r, new int[] { 0, Integer.MAX_VALUE });
			final int newLen = v[0] + 1;
			final int newSeed = Math.min(v[1], num);
			t.put(r, new int[] { newLen, newSeed });
			if (newLen == l)
				seed = Math.min(seed, newSeed);
			else if (newLen > l) {
				l = newLen;
				seed = newSeed;
			}
		}
		return seed;
	}
}
