package com.coding.challenge.string;

class Largest3SameDigitNumberInString {
	Largest3SameDigitNumberInString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "777".equals(largestGoodInteger("6777133339"));
		assert "000".equals(largestGoodInteger("2300019"));
		assert "".equals(largestGoodInteger("42352338"));
	}

	static String largestGoodInteger(String num) {
		final int n = num.length();
		char maxGood = '\0';
		for (int i = 1, c = 1; i < n; i++) {
			final char ch = num.charAt(i);
			if (ch == num.charAt(i - 1))
				c = c + 1;
			else
				c = 1;

			if (c == 3 && ch > maxGood)
				maxGood = ch;
		}
		if (maxGood == '\0')
			return "";

		final char[] ans = { maxGood, maxGood, maxGood };
		return new String(ans);
	}
}
