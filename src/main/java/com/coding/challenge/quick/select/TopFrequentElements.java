package com.coding.challenge.quick.select;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class TopFrequentElements {
	TopFrequentElements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 1, 2, 2, 3 };
		final int[] expectedOne = { 1, 2 };
		assert Arrays.equals(topKFrequent(numsOne, 2), expectedOne);

		final int[] numsTwo = { 1 };
		final int[] expectedTwo = { 1 };
		assert Arrays.equals(topKFrequent(numsTwo, 1), expectedTwo);

		final int[] numsThree = { 4, 1, -1, 2, -1, 2, 3 };
		final int[] expectedThree = { -1, 2 };
		assert Arrays.equals(topKFrequent(numsThree, 2), expectedThree);
	}

	static int[] topKFrequent(int[] nums, int k) {
		final Map<Integer, Integer> t = new HashMap<>();
		for (int val : nums)
			t.merge(val, 1, Integer::sum);

		final int n = t.size();
		final int[] f = new int[n];
		int i = 0;
		for (int v : t.values()) {
			f[i] = v;
			i = i + 1;
		}

		final int kthLargestFreq = QuickSelect.randomizedSelect(f, 0, n - 1, n - k + 1);
		final int[] a = new int[k];
		int j = 0;
		for (Entry<Integer, Integer> entry : t.entrySet()) {
			if (entry.getValue() >= kthLargestFreq) {
				a[j] = entry.getKey();
				j = j + 1;
			}
		}
		return a;
	}

}
