package com.coding.challenge.greedy;

class ConstructStringWithRepeatLimit {
	private static final char FIRST_LETTER = 'a';

	ConstructStringWithRepeatLimit() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "zzcccac".equals(repeatLimitedString("cczazcc", 3));
		assert "bbabaa".equals(repeatLimitedString("aababab", 2));
	}

	static String repeatLimitedString(String s, int repeatLimit) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		final StringBuilder ans = new StringBuilder();
		for (int i = 25, j = i - 1; i >= 0; i--) {
			while (f[i] > 0) {
				final int c = Math.min(repeatLimit, f[i]);
				final char ch = (char) (FIRST_LETTER + i);
				for (int k = 0; k < c; k++)
					ans.append(ch);

				f[i] = f[i] - c;

				if (j >= i)
					j = i - 1;

				while (j >= 0 && f[j] == 0)
					j = j - 1;

				if (j == -1)
					return ans.toString();

				if (f[i] > 0) {
					ans.append((char) (FIRST_LETTER + j));
					f[j] = f[j] - 1;
				}
			}
		}
		return ans.toString();
	}
}
