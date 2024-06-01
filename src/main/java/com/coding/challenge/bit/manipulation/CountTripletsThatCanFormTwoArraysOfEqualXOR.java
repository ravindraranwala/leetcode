package com.coding.challenge.bit.manipulation;

import java.util.HashMap;
import java.util.Map;

class CountTripletsThatCanFormTwoArraysOfEqualXOR {
	CountTripletsThatCanFormTwoArraysOfEqualXOR() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 2, 3, 1, 6, 7 };
		assert countTriplets(arr1) == 4;

		final int[] arr2 = { 1, 1, 1, 1, 1 };
		assert countTriplets(arr2) == 10;

		final int[] arr3 = { 10 };
		assert countTriplets(arr3) == 0;
	}

	static int countTriplets(int[] arr) {
		final int n = arr.length;
		final Map<Integer, Integer> xorFreq = new HashMap<>();
		final Map<Integer, Integer> xorTripletsCnt = new HashMap<>();
		final Map<Integer, Integer> xorLastIdx = new HashMap<>();
		xorFreq.put(0, 1);
		xorLastIdx.put(0, -1);
		xorTripletsCnt.put(0, 0);
		int c = 0;
		for (int i = 0, xor = 0; i < n; i++) {
			xor = xor ^ arr[i];
			int triplets = 0;
			if (xorFreq.containsKey(xor))
				triplets = xorTripletsCnt.get(xor) + xorFreq.get(xor) * (i - xorLastIdx.get(xor)) - 1;

			c = c + triplets;
			xorFreq.merge(xor, 1, Integer::sum);
			xorTripletsCnt.put(xor, triplets);
			xorLastIdx.put(xor, i);
		}
		return c;
	}
}
