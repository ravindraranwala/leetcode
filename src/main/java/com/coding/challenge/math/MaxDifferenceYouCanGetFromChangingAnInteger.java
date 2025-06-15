package com.coding.challenge.math;

class MaxDifferenceYouCanGetFromChangingAnInteger {
	MaxDifferenceYouCanGetFromChangingAnInteger() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxDiff(555) == 888;
		assert maxDiff(9) == 8;
		assert maxDiff(172) == 870;
	}

	static int maxDiff(int num) {
		final int a = MaximumDifferenceByRemappingDigit.remapDigit(num,
				MaximumDifferenceByRemappingDigit.findMostSignificantDigitNotEqualToTarget(num, 9), 9);
		final int mostSignificantDigit = msd(num);
		int b = num;
		final int leftMostDigitGreaterThanOne = leftMostDigitGreaterThanTarget(num, 1);
		if (mostSignificantDigit > 1)
			b = MaximumDifferenceByRemappingDigit.remapDigit(num, mostSignificantDigit, 1);
		else if (leftMostDigitGreaterThanOne > 1)
			b = MaximumDifferenceByRemappingDigit.remapDigit(num, leftMostDigitGreaterThanOne, 0);
		
		return a - b;
	}
	
	private static int msd(int num) {
		int d = -1;
		for (int currNum = num; currNum > 0; currNum = currNum / 10) 
			d = currNum % 10;
		return d;
	}

	private static int leftMostDigitGreaterThanTarget(int num, int target) {
		int d = target;
		for (int currNum = num; currNum > 0; currNum = currNum / 10) {
			final int digit = currNum % 10;
			if (digit > target)
				d = digit;
		}
		return d;
	}
}
