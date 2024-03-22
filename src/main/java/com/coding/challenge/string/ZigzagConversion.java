package com.coding.challenge.string;

class ZigzagConversion {
	ZigzagConversion() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "PAHNAPLSIIGYIR".equals(convert("PAYPALISHIRING", 3));
		assert "PINALSIGYAHRPI".equals(convert("PAYPALISHIRING", 4));
		assert "A".equals(convert("A", 1));
	}

	static String convert(String s, int numRows) {
		final StringBuilder[] a = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++)
			a[i] = new StringBuilder();

		final int n = s.length();
		int i = 0;
		while (i < n) {
			for (int j = 0; j < numRows && i < n; j++) {
				a[j].append(s.charAt(i));
				i = i + 1;
			}

			for (int k = numRows - 2; k > 0 && i < n; k--) {
				a[k].append(s.charAt(i));
				i = i + 1;
			}
		}

		final StringBuilder ans = new StringBuilder();
		for (StringBuilder row : a)
			ans.append(row.toString());

		return ans.toString();
	}
}
