package com.coding.challenge.sorting;

import java.util.NavigableMap;
import java.util.TreeMap;

class HandOfStraights {
	HandOfStraights() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] handOne = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
		assert isNStraightHand(handOne, 3);

		final int[] handTwo = { 1, 2, 3, 4, 5 };
		assert !isNStraightHand(handTwo, 4);
	}

	static boolean isNStraightHand(int[] hand, int groupSize) {
		final NavigableMap<Integer, Integer> f = new TreeMap<>();
		for (int v : hand)
			f.merge(v, 1, Integer::sum);

		while (f.size() >= groupSize) {
			for (int i = 0, l = f.firstKey(); i < groupSize; i++) {
				if (!f.containsKey(l + i))
					return false;
				final int v = f.get(l + i) - 1;
				if (v == 0)
					f.remove(l + i);
				else
					f.put(l + i, v);
			}
		}
		return f.isEmpty();
	}
}
