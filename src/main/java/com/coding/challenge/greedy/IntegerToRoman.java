package com.coding.challenge.greedy;

class IntegerToRoman {
	private static String[] romanNumerals = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
	private static int[] decimalEquivalent = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

	IntegerToRoman() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "III".equals(intToRoman(3));
		assert "LVIII".equals(intToRoman(58));
		assert "MCMXCIV".equals(intToRoman(1994));
	}

	static String intToRoman(int num) {
		final StringBuilder ans = new StringBuilder();
		final int n = romanNumerals.length;
		int currNum = num;
		while (currNum > 0) {
			int i = n - 1;
			/*
			 * Greedy choice property: Always chose the largest possible number and solve
			 * the remaining subproblem optimally.
			 */
			while (decimalEquivalent[i] > currNum)
				i = i - 1;
			ans.append(romanNumerals[i]);
			currNum = currNum - decimalEquivalent[i];
		}
		return ans.toString();
	}
}
