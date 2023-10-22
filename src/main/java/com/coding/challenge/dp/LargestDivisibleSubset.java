package com.coding.challenge.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LargestDivisibleSubset {
	LargestDivisibleSubset() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3 };
		final Set<Integer> expOne = Set.of(1, 2);
		assert new HashSet<>(largestDivisibleSubset(numsOne)).containsAll(expOne);

		final int[] numsTwo = { 1, 2, 4, 8 };
		final Set<Integer> expTwo = Set.of(1, 2, 4, 8);
		assert new HashSet<>(largestDivisibleSubset(numsTwo)).containsAll(expTwo);

		final int[] numsThree = { 2, 3, 8, 9, 27 };
		final Set<Integer> expThree = Set.of(3, 9, 27);
		assert new HashSet<>(largestDivisibleSubset(numsThree)).containsAll(expThree);

		final int[] numsFour = { 5, 9, 18, 54, 108, 540, 90, 180, 360, 720 };
		final Set<Integer> expFour = Set.of(9, 18, 90, 180, 360, 720);
		assert new HashSet<>(largestDivisibleSubset(numsFour)).containsAll(expFour);

	}

	static List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		final int n = nums.length;
		final int[] l = new int[n];
		final int[] p = new int[n];
		l[0] = 1;
		p[0] = -1;
		int k = 0;

		for (int i = 1; i < n; i++) {
			l[i] = 1;
			p[i] = -1;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && l[j] + 1 > l[i]) {
					l[i] = l[j] + 1;
					p[i] = j;
					// keep track of the index of the optimal solution.
					if (l[i] > l[k])
						k = i;
				}
			}
		}
		// construct optimal solution.
		final List<Integer> s = new ArrayList<>();
		while (k >= 0) {
			s.add(nums[k]);
			k = p[k];
		}
		return s;
	}
}
