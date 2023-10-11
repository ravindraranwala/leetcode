package com.coding.challenge.two.sum;

import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
	final int[] numsOne;
	final int[] numsTwo;
	final Map<Integer, Integer> f = new HashMap<>();

	public FindSumPairs(int[] nums1, int[] nums2) {
		numsOne = nums1;
		numsTwo = nums2;
		for (int v : nums2)
			f.merge(v, 1, Integer::sum);
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 2, 2, 2, 3 };
		final int[] numsTwo = { 1, 4, 5, 2, 5, 4 };
		final FindSumPairs findSumPairs = new FindSumPairs(numsOne, numsTwo);
		assert findSumPairs.count(7) == 8;
		findSumPairs.add(3, 2);
		assert findSumPairs.count(8) == 2;
		assert findSumPairs.count(4) == 1;
		findSumPairs.add(0, 1);
		findSumPairs.add(1, 1);
		assert findSumPairs.count(7) == 11;
	}

	public void add(int index, int val) {
		f.put(numsTwo[index], f.get(numsTwo[index]) - 1);
		numsTwo[index] = numsTwo[index] + val;
		f.merge(numsTwo[index], 1, Integer::sum);
	}

	public int count(int tot) {
		int c = 0;
		for (int num1 : numsOne)
			if (f.containsKey(tot - num1))
				c = c + f.get(tot - num1);

		return c;
	}
}
