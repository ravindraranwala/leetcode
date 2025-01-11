package com.coding.challenge.segment.tree;

class ShiftingLettersII {
	private static final char FIRST_LETTER = 'a';

	ShiftingLettersII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] shifts1 = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
		assert "ace".equals(shiftingLetters("abc", shifts1));

		final int[][] shifts2 = { { 0, 0, 0 }, { 1, 1, 1 } };
		assert "catz".equals(shiftingLetters("dztz", shifts2));

		final int[][] shifts3 = { { 4, 8, 0 }, { 4, 4, 0 }, { 2, 4, 0 }, { 2, 4, 0 }, { 6, 7, 1 }, { 2, 2, 1 },
				{ 0, 2, 1 }, { 8, 8, 0 }, { 1, 3, 1 } };
		assert "ywxcxcqii".equals(shiftingLetters("xuwdbdqik", shifts3));
	}

	static String shiftingLetters(String s, int[][] shifts) {
		final int n = s.length();
		final SegmentTreeSum st = new SegmentTreeSum(n);
		for (int[] shift : shifts) {
			if (shift[2] == 1)
				st.increment(shift[0], shift[1], 1);
			else
				st.increment(shift[0], shift[1], -1);
		}

		final char[] ans = new char[n];
		for (int i = 0; i < n; i++) {
			final int offset = (st.sum(i, i) % 26);
			ans[i] = (char) (FIRST_LETTER + ((s.charAt(i) - FIRST_LETTER + offset + 26) % 26));
		}

		return new String(ans);
	}
}
