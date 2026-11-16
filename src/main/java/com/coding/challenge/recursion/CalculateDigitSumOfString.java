package com.coding.challenge.recursion;

class CalculateDigitSumOfString {
	private static final char ZERO = '0';

	CalculateDigitSumOfString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "135".equals(digitSum("11111222223", 3));
		assert "000".equals(digitSum("00000000", 3));
	}

	static String digitSum(String s, int k) {
		if (s.length() <= k)
			return s;

		final StringBuilder ans = new StringBuilder();
		final int n = s.length();
		int i = 0;
		while (i < n) {
			// read the next <= k block of digits in the input.
			final int end = i + k;
			int digitSum = 0;
			while (i < n && i < end) {
				digitSum = digitSum + (s.charAt(i) - ZERO);
				i = i + 1;
			}
			ans.append(digitSum);
		}
		return digitSum(ans.toString(), k);
	}
}
