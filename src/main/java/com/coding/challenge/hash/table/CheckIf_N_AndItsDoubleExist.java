package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class CheckIf_N_AndItsDoubleExist {
	CheckIf_N_AndItsDoubleExist() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] a1 = { 10, 2, 5, 3 };
		System.out.println(checkIfExist(a1));

		final int[] a2 = { 3, 1, 7, 11 };
		System.out.println(checkIfExist(a2));
	}

	static boolean checkIfExist(int[] arr) {
		final Set<Integer> t = new HashSet<>();
		for (int val : arr) {
			if (val % 2 == 0 && t.contains(val / 2))
				return true;
			if (t.contains(val * 2))
				return true;

			t.add(val);
		}
		// No solution exists.
		return false;
	}
}
