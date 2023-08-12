package com.coding.challenge.binary.search;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

class NumberOfFlowersInFullBloom {
	NumberOfFlowersInFullBloom() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] flowersOne = { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
		final int[] peopleOne = { 2, 3, 7, 11 };
		final int[] expectedOne = { 1, 2, 2, 2 };
		assert Arrays.equals(expectedOne, fullBloomFlowers(flowersOne, peopleOne));

		final int[][] flowersTwo = { { 1, 10 }, { 3, 3 } };
		final int[] peopleTwo = { 3, 3, 2 };
		final int[] expectedTwo = { 2, 2, 1 };
		assert Arrays.equals(expectedTwo, fullBloomFlowers(flowersTwo, peopleTwo));
	}

	static int[] fullBloomFlowers(int[][] flowers, int[] people) {
		final int m = flowers.length;
		final int[] s = new int[m];
		final int[] e = new int[m];

		for (int i = 0; i < m; i++) {
			s[i] = flowers[i][0];
			e[i] = flowers[i][1];
		}

		Arrays.sort(s);
		Arrays.sort(e);
		final int n = people.length;
		final int[] f = new int[n];
		for (int i = 0; i < n; i++) {
			final int a = people[i];
			final int j = BinarySearch.predecessor(s, a + 1);
			final int k = BinarySearch.successor(e, a - 1);
			f[i] = Math.max(j - k + 1, 0);
		}
		return f;
	}
}
