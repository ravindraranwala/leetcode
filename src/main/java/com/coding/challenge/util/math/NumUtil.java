package com.coding.challenge.util.math;

public class NumUtil {
	NumUtil() {
		throw new AssertionError();
	}

	public static int digitSum(int n) {
		int sum = 0;
		for (int num = n; num > 0; num = num / 10) {
			final int digit = num % 10;
			sum = sum + digit;
		}
		return sum;
	}

	public static int digitProduct(int n) {
		int prd = 1;
		for (int num = n; num > 0; num = num / 10) {
			final int digit = num % 10;
			prd = prd * digit;
		}
		return prd;
	}
}
