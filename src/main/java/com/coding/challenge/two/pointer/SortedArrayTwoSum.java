package com.coding.challenge.two.pointer;

import java.util.Arrays;

class SortedArrayTwoSum {

	SortedArrayTwoSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 7, 11, 15 };
		System.out.println(Arrays.toString(twoSum(numsOne, 9)));

		final int[] numsTwo = { 2, 3, 4 };
		System.out.println(Arrays.toString(twoSum(numsTwo, 6)));

		final int[] numsThree = { -1, 0 };
		System.out.println(Arrays.toString(twoSum(numsThree, -1)));
	}

	static int[] twoSum(int[] numbers, int target) {
		final int[] r = { -1, -1 };
		int i = 0;
		int j = numbers.length - 1;

		while (i < j) {
			if (numbers[i] + numbers[j] > target)
				j = j - 1;
			else if (numbers[i] + numbers[j] < target)
				i = i + 1;
			else {
				r[0] = i + 1;
				r[1] = j + 1;
				i = i + 1;
			}
		}
		return r;
	}
}
