package com.coding.challenge.quick.select;

import java.util.Arrays;

class SortColors {
	SortColors() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] colorsOne = { 1, 0, 2, 1, 2, 0 };
		sortColors(colorsOne);
		final int[] expColorsOne = { 0, 0, 1, 1, 2, 2 };
		assert Arrays.equals(expColorsOne, colorsOne);

		final int[] colorsTwo = { 2, 0, 1 };
		sortColors(colorsTwo);
		final int[] expColorsTwo = { 0, 1, 2 };
		assert Arrays.equals(expColorsTwo, colorsTwo);

		final int[] colorsThree = { 2, 1, 2, 2, 2 };
		sortColors(colorsThree);
		final int[] expColorsThree = { 1, 2, 2, 2, 2 };
		assert Arrays.equals(expColorsThree, colorsThree);

		final int[] colorsFour = { 0, 2, 1, 2 };
		sortColors(colorsFour);
		final int[] expColorsFour = { 0, 1, 2, 2 };
		assert Arrays.equals(expColorsFour, colorsFour);

		final int[] colorsFive = { 1, 0 };
		sortColors(colorsFive);
		final int[] expColorsFive = { 0, 1 };
		assert Arrays.equals(expColorsFive, colorsFive);
	}

	static void sortColors(int[] nums) {
		final int n = nums.length;
		int i = -1;
		int j = -1;
		for (int k = 0; k < n; k++) {
			if (nums[k] == 0) {
				j = j + 1;
				exchange(nums, j, k);
				i = i + 1;
				exchange(nums, i, j);
			} else if (nums[k] == 1) {
				j = j + 1;
				exchange(nums, j, k);
			}
		}
	}

	private static void exchange(int[] a, int i, int j) {
		final int tmp = a[j];
		a[j] = a[i];
		a[i] = tmp;
	}
}
