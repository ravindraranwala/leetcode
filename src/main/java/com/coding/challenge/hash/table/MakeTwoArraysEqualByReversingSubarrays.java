package com.coding.challenge.hash.table;

class MakeTwoArraysEqualByReversingSubarrays {
	MakeTwoArraysEqualByReversingSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] target1 = { 1, 2, 3, 4 };
		final int[] arr1 = { 2, 4, 1, 3 };
		assert canBeEqual(target1, arr1);

		final int[] target2 = { 7 };
		final int[] arr2 = { 7 };
		assert canBeEqual(target2, arr2);

		final int[] target3 = { 3, 7, 9 };
		final int[] arr3 = { 3, 7, 11 };
		assert !canBeEqual(target3, arr3);
	}

	static boolean canBeEqual(int[] target, int[] arr) {
		final int n = arr.length;
		final int[] fTarget = new int[1001];
		final int[] fArr = new int[1001];
		for (int i = 0; i < n; i++) {
			fTarget[target[i]] = fTarget[target[i]] + 1;
			fArr[arr[i]] = fArr[arr[i]] + 1;
		}

		for (int i = 0; i <= 1000; i++)
			if (fTarget[i] != fArr[i])
				return false;

		return true;
	}
}
