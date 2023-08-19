package com.coding.challenge.dp;

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

		final int[] numsFive = { 1, 2, 3, 15, 16, 17, 18 };
		assert deleteAndEarn(numsFive) == 38;
	}

	static int deleteAndEarn(int[] nums) {
		final Map<Integer, Integer> p = new HashMap<Integer, Integer>();
		for (int e : nums)
			p.merge(e, e, Integer::sum);
		final Map<Integer, Integer> s = new HashMap<>();
		final Integer[] a = p.keySet().toArray(new Integer[0]);
		int points = 0;
		for (int e : a) {
			visitGroup(e, p, s);
			/*
			 * Check if the current element is the smallest in it's group. If so, add it's
			 * solution to the final result, as it is the optimal solution attainable from
			 * that group.
			 */
			if (!p.containsKey(e - 1))
				points = points + s.get(e);
		}
		return points;
	}

	private static void visitGroup(int e, Map<Integer, Integer> p, final Map<Integer, Integer> s) {
		// trivial case of the recursion.
		if (s.containsKey(e))
			return;
		// Memoization.
		if (p.containsKey(e + 1))
			visitGroup(e + 1, p, s);

		final int sln = Math.max(s.getOrDefault(e + 1, 0), s.getOrDefault(e + 2, 0) + p.get(e));
		s.put(e, sln);
	}
}
