package com.coding.challenge.radix.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SortThePeople {
	SortThePeople() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] names1 = { "Mary", "John", "Emma" };
		final int[] heights1 = { 180, 165, 170 };
		final String[] sortedPeople1 = { "Mary", "Emma", "John" };
		assert Arrays.equals(sortedPeople1, sortPeople(names1, heights1));

		final String[] names2 = { "Alice", "Bob", "Bob" };
		final int[] heights2 = { 155, 185, 150 };
		final String[] sortedPeople2 = { "Bob", "Alice", "Bob" };
		assert Arrays.equals(sortedPeople2, sortPeople(names2, heights2));
	}

	static String[] sortPeople(String[] names, int[] heights) {
		final int n = names.length;
		final Map<Integer, String> heightToName = new HashMap<>();
		for (int i = 0; i < n; i++)
			heightToName.put(heights[i], names[i]);

		final int[] sortedHeights = RadixSort.radixSort(heights, 6);
		final String[] sortedNames = new String[n];
		for (int i = 0; i < n; i++)
			sortedNames[n - 1 - i] = heightToName.get(sortedHeights[i]);
		return sortedNames;
	}
}
