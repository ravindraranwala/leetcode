package com.coding.challenge.math;

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
		int prd = 1;
		int sum = 0;
		for (int num = n; num > 0; num = num / 10) {
			final int digit = num % 10;
			prd = prd * digit;
			sum = sum + digit;
		}
		return prd - sum;
	}
}
