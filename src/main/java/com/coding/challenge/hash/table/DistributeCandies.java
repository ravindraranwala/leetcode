package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class DistributeCandies {
	DistributeCandies() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] candyType1 = { 1, 1, 2, 2, 3, 3 };
		assert distributeCandies(candyType1) == 3;

		final int[] candyType2 = { 1, 1, 2, 3 };
		assert distributeCandies(candyType2) == 2;

		final int[] candyType3 = { 6, 6, 6, 6 };
		assert distributeCandies(candyType3) == 1;
	}

	static int distributeCandies(int[] candyType) {
		final Set<Integer> candiTypes = new HashSet<>();
		for (int type : candyType)
			candiTypes.add(type);
		return Math.min(candyType.length / 2, candiTypes.size());
	}
}
