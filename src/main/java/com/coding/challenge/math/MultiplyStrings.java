package com.coding.challenge.math;

class MultiplyStrings {
	private static final char ZERO = '0';

	MultiplyStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "6".equals(multiply("2", "3"));
		assert "56088".equals(multiply("123", "456"));
		assert "0".equals(multiply("9133", "0"));
	}

	static String multiply(String num1, String num2) {
		final int m = num1.length();
		final int n = num2.length();
		final int l = Math.max(m * n, m + n);
		final int[] a = new int[l];
		for (int i = m - 1; i >= 0; i--) {
			final int d1 = num1.charAt(i) - ZERO;
			int cf = 0;
			int offset = 0;
			for (int j = n - 1, k = m - 1 - i; j >= 0; j--) {
				final int d2 = num2.charAt(j) - ZERO;
				offset = k + n - 1 - j;
				final int currIdx = l - 1 - offset;
				final int val = d1 * d2 + cf + a[currIdx];
				a[currIdx] = val % 10;
				cf = val / 10;
			}
			a[l - 2 - offset] = cf;
		}
		// avoiding leading zeros.
		int i = 0;
		while (i < l && a[i] == 0)
			i = i + 1;
		if (i == l)
			return "0";

		final int len = l - i;
		final char[] s = new char[len];
		for (int j = 0; j < len; j++)
			s[j] = (char) (a[i + j] + ZERO);
		return String.valueOf(s);
	}
}
