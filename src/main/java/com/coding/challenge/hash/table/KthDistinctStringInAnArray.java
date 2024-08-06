package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class KthDistinctStringInAnArray {
	KthDistinctStringInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] arr1 = { "d", "b", "c", "b", "c", "a" };
		assert "a".equals(kthDistinct(arr1, 2));

		final String[] arr2 = { "aaa", "aa", "a" };
		assert "aaa".equals(kthDistinct(arr2, 1));

		final String[] arr3 = { "a", "b", "a" };
		assert "".equals(kthDistinct(arr3, 3));
	}

	static String kthDistinct(String[] arr, int k) {
		final Map<String, Integer> f = new HashMap<>();
		for (String s : arr)
			f.merge(s, 1, Integer::sum);

		int c = 0;
		for (String s : arr) {
			if (f.get(s) == 1)
				c = c + 1;
			if (c == k)
				return s;
		}
		return "";
	}
}
