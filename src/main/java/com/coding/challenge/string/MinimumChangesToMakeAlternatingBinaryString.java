package com.coding.challenge.string;

class MinimumChangesToMakeAlternatingBinaryString {
	private static final char ZERO = '0';
	private static final char ONE = '1';

	MinimumChangesToMakeAlternatingBinaryString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minOperations("0100") == 1;
		assert minOperations("10") == 0;
		assert minOperations("1111") == 2;
		assert minOperations("11010100001101100111") == 7;
		assert minOperations("001110111011011110100001110") == 12;
	}

	static int minOperations(String s) {
		return Math.min(minChanges(s, ONE), minChanges(s, ZERO));
	}

	private static int minChanges(String s, char last) {
		int c = 0;
		for (char ch : s.toCharArray()) {
			if (ch == last) {
				c = c + 1;
				if (ch == ZERO)
					last = ONE;
				else
					last = ZERO;
			} else
				last = ch;
		}
		return c;
	}
}
