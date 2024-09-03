package com.coding.challenge.math;

class SumOfDigitsOfStringAfterConvert {
	private static final char FIRST_LETTER = 'a';

	SumOfDigitsOfStringAfterConvert() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert getLucky("iiii", 1) == 36;
		assert getLucky("leetcode", 2) == 6;
		assert getLucky("zbax", 2) == 8;
	}

	static int getLucky(String s, int k) {
		int sum = 0;
		for (char ch : s.toCharArray())
			sum = sum + digitSum(ch - FIRST_LETTER + 1);

		for (int i = 1; i < k; i++)
			sum = digitSum(sum);

		return sum;
	}

	private static int digitSum(int sum) {
		int s = sum;
		int digitSum = 0;
		while (s > 0) {
			digitSum = digitSum + s % 10;
			s = s / 10;
		}
		return digitSum;
	}
}
