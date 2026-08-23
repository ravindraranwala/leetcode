package com.coding.challenge.math;

import com.coding.challenge.util.math.NumUtil;

class SubtractProductAndSumOfDigitsOfAnInteger {
	SubtractProductAndSumOfDigitsOfAnInteger() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert subtractProductAndSum(234) == 15;
		assert subtractProductAndSum(4421) == 21;
		assert subtractProductAndSum(1) == 0;
	}

	static int subtractProductAndSum(int n) {
		return NumUtil.digitProduct(n) - NumUtil.digitSum(n);
	}
}
