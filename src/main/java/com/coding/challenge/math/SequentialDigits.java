package com.coding.challenge.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SequentialDigits {
	private static final int MAX_DIGIT = 9;
	private static final int BASE = 10;

	SequentialDigits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> l1 = Arrays.asList(123, 23);
		assert l1.equals(sequentialDigits(100, 300));

		final List<Integer> l2 = Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789, 12345);
		assert l2.equals(sequentialDigits(1000, 13000));
	}

	static List<Integer> sequentialDigits(int low, int high) {
		final List<Integer> ans = new ArrayList<>();
		final int[] vals = new int[10];
		for (int val = 1; val <= MAX_DIGIT; val++) {
			vals[val] = val;
			if (val >= low && val <= high)
				ans.add(val);
		}

		for (int len = 2; len <= MAX_DIGIT; len++) {
			for (int startingDigit = 1; startingDigit <= MAX_DIGIT; startingDigit++) {
				int prevVal = vals[startingDigit];
				final int lastDigit = prevVal % BASE;
				if (lastDigit < MAX_DIGIT) {
					final int currVal = prevVal * BASE + lastDigit + 1;
					vals[startingDigit] = currVal;
					if (currVal >= low && currVal <= high)
						ans.add(currVal);
				}
			}
		}

		return ans;
	}
}
