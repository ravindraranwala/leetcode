package com.coding.challenge.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FindAllDuplicatesInArray {
	FindAllDuplicatesInArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 4, 3, 2, 7, 8, 2, 3, 1 };
		assert Arrays.asList(2, 3).equals(findDuplicates(numsOne));

		final int[] numsTwo = { 1, 1, 2, 4 };
		assert Arrays.asList(1).equals(findDuplicates(numsTwo));

		final int[] numsThree = { 1 };
		assert Collections.emptyList().equals(findDuplicates(numsThree));
	}

	static List<Integer> findDuplicates(int[] nums) {
		final int n = nums.length;
		final List<Integer> l = new ArrayList<>();
		for (int i = 0; i < n; i++)
			l.add(0);

		for (int v : nums)
			l.set(v - 1, l.get(v - 1) + 1);

		int p = 0;
		for (int i = 0; i < n; i++) {
			if (l.get(i) == 2) {
				l.set(p, i + 1);
				p = p + 1;
			}
		}

		return l.subList(0, p);
	}
}
