package com.coding.challenge.string;

class AddBinary {
	private static final char ZERO = '0';

	AddBinary() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "100".equals(addBinary("11", "1"));
		assert "10101".equals(addBinary("1010", "1011"));
	}

	static String addBinary(String a, String b) {
		final int m = a.length();
		final int n = b.length();
		final int l = Math.max(m, n);
		final StringBuilder s = new StringBuilder();
		int carryFwd = 0;

		for (int i = 1; i <= l; i++) {
			int firstBit = 0;
			if (i <= m)
				firstBit = a.charAt(m - i) - ZERO;

			int secondBit = 0;
			if (i <= n)
				secondBit = b.charAt(n - i) - ZERO;

			final int val = firstBit + secondBit + carryFwd;
			final char ch = (val % 2) == 0 ? '0' : '1';
			s.append(ch);
			carryFwd = val / 2;
		}

		if (carryFwd == 1)
			s.append('1');

		return s.reverse().toString();
	}
}
