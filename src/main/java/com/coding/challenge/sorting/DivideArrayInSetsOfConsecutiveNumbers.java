package com.coding.challenge.sorting;

import java.util.NavigableMap;
import java.util.TreeMap;

class DivideArrayInSetsOfConsecutiveNumbers {
	DivideArrayInSetsOfConsecutiveNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3, 3, 4, 4, 5, 6 };
		assert isPossibleDivide(numsOne, 4);

		final int[] numsTwo = { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };
		assert isPossibleDivide(numsTwo, 3);

		final int[] numsThree = { 1, 2, 3, 4 };
		assert !isPossibleDivide(numsThree, 3);
	}

	static boolean isPossibleDivide(int[] nums, int k) {
		final NavigableMap<Integer, Integer> f = new TreeMap<>();
		for (int v : nums)
			f.merge(v, 1, Integer::sum);

		while (f.size() >= k) {
			for (int i = 0, l = f.firstKey(); i < k; i++) {
				if (!f.containsKey(l + i))
					return false;
				final int v = f.get(l + i) - 1;
				if (v == 0)
					f.remove(l + i);
				else
					f.put(l + i, v);
			}
		}
		return f.isEmpty();
	}
}
