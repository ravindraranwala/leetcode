package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class CheckIfNAndItsDoubleExist {
	CheckIfNAndItsDoubleExist() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 10, 2, 5, 3 };
		assert checkIfExist(arr1);

		final int[] arr2 = { 3, 1, 7, 11 };
		assert !checkIfExist(arr2);

		final int[] arr3 = { -2, 0, 10, -19, 4, 6, -8 };
		assert !checkIfExist(arr3);

		final int[] arr4 = { 0, 0 };
		assert checkIfExist(arr4);

		final int[] arr5 = { -20, 8, -6, -14, 0, -19, 14, 4 };
		assert checkIfExist(arr5);

		final int[] arr6 = { -2, 0, 10, -19, 4, 6, -8 };
		assert !checkIfExist(arr6);
	}

	static boolean checkIfExist(int[] arr) {
		final Set<Integer> s = new HashSet<>();
		int zeros = 0;
		for (int num : arr) {
			s.add(num);
			if (num == 0)
				zeros = zeros + 1;
		}

		for (int num : arr) {
			if (num == 0 && zeros > 1)
				return true;
			if (num != 0 && s.contains(num * 2))
				return true;
		}

		return false;
	}
}
