package com.coding.challenge.math;

import com.coding.challenge.util.math.NumUtil;

class CheckDivisibilityByDigitSumAndProduct {
	CheckDivisibilityByDigitSumAndProduct() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert checkDivisibility(99);
		assert !checkDivisibility(23);
	}

	static boolean checkDivisibility(int n) {
		return n % (NumUtil.digitSum(n) + NumUtil.digitProduct(n)) == 0;
	}
}
