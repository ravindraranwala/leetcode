package com.coding.challenge.math;

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
	private static Map<String, Integer> romanToDecimal = new HashMap<>();
	static {
		romanToDecimal.put("I", 1);
		romanToDecimal.put("IV", 4);
		romanToDecimal.put("V", 5);
		romanToDecimal.put("IX", 9);
		romanToDecimal.put("X", 10);
		romanToDecimal.put("XL", 40);
		romanToDecimal.put("L", 50);
		romanToDecimal.put("XC", 90);
		romanToDecimal.put("C", 100);
		romanToDecimal.put("CD", 400);
		romanToDecimal.put("D", 500);
		romanToDecimal.put("CM", 900);
		romanToDecimal.put("M", 1000);
	}

	RomanToInteger() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert romanToInt("III") == 3;
		assert romanToInt("LVIII") == 58;
		assert romanToInt("MCMXCIV") == 1994;
	}

	static int romanToInt(String s) {
		final int n = s.length();
		int i = 0;
		int decimal = 0;
		while (i < n - 1) {
			final String twoLetters = s.substring(i, i + 2);
			if (romanToDecimal.containsKey(twoLetters)) {
				decimal = decimal + romanToDecimal.get(twoLetters);
				i = i + 2;
			} else {
				decimal = decimal + romanToDecimal.get(String.valueOf(s.charAt(i)));
				i = i + 1;
			}
		}
		if (i == n - 1)
			decimal = decimal + romanToDecimal.get(s.charAt(i) + "");
		return decimal;
	}
}
