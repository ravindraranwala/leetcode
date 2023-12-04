package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAllLonelyNumbersInArray {
	FindAllLonelyNumbersInArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 10, 6, 5, 8 };
		final List<Integer> l1 = Arrays.asList(10, 8);
		assert l1.equals(findLonely(numsOne));

		final int[] numsTwo = { 1, 3, 5, 3 };
		final List<Integer> l2 = Arrays.asList(1, 5);
		assert l2.equals(findLonely(numsTwo));
	}

	static List<Integer> findLonely(int[] nums) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int v : nums)
			f.merge(v, 1, Integer::sum);

		final List<Integer> l = new ArrayList<>();
		for (int v : nums)
			if (f.get(v) == 1 && !f.containsKey(v - 1) && !f.containsKey(v + 1))
				l.add(v);

		return l;
	}
}
