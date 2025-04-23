package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CountLargestGroup {
	CountLargestGroup() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countLargestGroup(13) == 4;
		assert countLargestGroup(2) == 2;
	}

	static int countLargestGroup(int n) {
		final Map<Integer, Integer> groupSize = new HashMap<>();
		for (int num = 1; num <= n; num++)
			groupSize.merge(digitSum(num), 1, Integer::sum);

		int largestSize = 0;
		for (int size : groupSize.values())
			largestSize = Math.max(largestSize, size);

		int c = 0;
		for (int size : groupSize.values())
			if (size == largestSize)
				c = c + 1;

		return c;
	}

	private static int digitSum(int num) {
		int s = 0;
		while (num > 0) {
			s = s + num % 10;
			num = num / 10;
		}
		return s;
	}
}
