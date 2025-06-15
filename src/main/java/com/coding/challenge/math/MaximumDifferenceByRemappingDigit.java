package com.coding.challenge.math;

class MaximumDifferenceByRemappingDigit {
	MaximumDifferenceByRemappingDigit() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minMaxDifference(11891) == 99009;
		assert minMaxDifference(90) == 99;
	}

	static int minMaxDifference(int num) {
		return remapDigit(num, findMostSignificantDigitNotEqualToTarget(num, 9), 9)
				- remapDigit(num, findMostSignificantDigitNotEqualToTarget(num, 0), 0);
	}

	private static int findMostSignificantDigitNotEqualToTarget(int num, int target) {
		int d = target;
		for (int currNum = num; currNum > 0; currNum = currNum / 10) {
			final int digit = currNum % 10;
			if (digit != target)
				d = digit;
		}
		return d;
	}

	private static int remapDigit(int num, int s, int t) {
		int ans = 0;
		for (int currNum = num, posVal = 1; currNum > 0; currNum = currNum / 10, posVal = posVal * 10) {
			final int digit = currNum % 10;
			if (digit == s)
				ans = ans + t * posVal;
			else
				ans = ans + digit * posVal;
		}
		return ans;
	}
}
