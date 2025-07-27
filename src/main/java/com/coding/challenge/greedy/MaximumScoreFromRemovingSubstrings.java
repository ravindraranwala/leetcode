package com.coding.challenge.greedy;

class MaximumScoreFromRemovingSubstrings {
	MaximumScoreFromRemovingSubstrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximumGain("cdbcbbaaabab", 4, 5) == 19;
		assert maximumGain("aabbaaxybbaabb", 5, 4) == 20;
		assert maximumGain("aaaabbbb", 4, 5) == 16;
	}

	static int maximumGain(String s, int x, int y) {
		// init.
		final char firstLetter = x > y ? 'a' : 'b';
		final char secondLetter = x > y ? 'b' : 'a';
		final int minPoints = Math.min(x, y);
		final int maxPoints = Math.max(x, y);
		int firstCnt = 0;
		int secondCnt = 0;
		int p = 0;

		for (char ch : s.toCharArray()) {
			if (ch == firstLetter)
				firstCnt = firstCnt + 1;
			else if (ch == secondLetter) {
				if (firstCnt > 0) {
					firstCnt = firstCnt - 1;
					p = p + maxPoints;
				} else
					secondCnt = secondCnt + 1;
			} else {
				p = p + Math.min(firstCnt, secondCnt) * minPoints;
				firstCnt = 0;
				secondCnt = 0;
			}
		}
		return p + Math.min(firstCnt, secondCnt) * minPoints;
	}
}
