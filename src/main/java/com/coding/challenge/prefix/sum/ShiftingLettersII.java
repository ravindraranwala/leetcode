package com.coding.challenge.prefix.sum;

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
		final int[] moves = new int[n + 1];
		for (int[] shift : shifts) {
			final int currMove = shift[2] == 1 ? 1 : -1;
			moves[shift[0]] = moves[shift[0]] + currMove;
			moves[shift[1] + 1] = moves[shift[1] + 1] - currMove;
		}

		final char[] ans = new char[n];
		for (int i = 0, preSum = 0; i < n; i++) {
			preSum = preSum + moves[i];
			final int shiftCnt = preSum % 26;
			ans[i] = (char) (FIRST_LETTER + ((s.charAt(i) - FIRST_LETTER + shiftCnt + 26) % 26));
		}
		return new String(ans);
	}
}
