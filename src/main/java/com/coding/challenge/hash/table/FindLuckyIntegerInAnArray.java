package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class FindLuckyIntegerInAnArray {

	FindLuckyIntegerInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 2, 2, 3, 4 };
		assert findLucky(arr1) == 2;

		final int[] arr2 = { 1, 2, 2, 3, 3, 3 };
		assert findLucky(arr2) == 3;

		final int[] arr3 = { 2, 2, 2, 3, 3 };
		assert findLucky(arr3) == -1;
	}

	static int findLucky(int[] arr) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int val : arr)
			f.merge(val, 1, Integer::sum);

		int luckyInt = -1;
		for (Entry<Integer, Integer> e : f.entrySet())
			if (e.getKey().equals(e.getValue()))
				luckyInt = Math.max(luckyInt, e.getKey());

		return luckyInt;
	}
}
