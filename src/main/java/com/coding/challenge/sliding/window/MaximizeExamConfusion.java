package com.coding.challenge.sliding.window;

class MaximizeExamConfusion {
	private static final char TRUE = 'T';

	MaximizeExamConfusion() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String answerKeyOne = "TTFF";
		assert maxConsecutiveAnswers(answerKeyOne, 2) == 4;

		final String answerKeyTwo = "TFFT";
		assert maxConsecutiveAnswers(answerKeyTwo, 1) == 3;

		final String answerKeyThree = "TTFTTFTT";
		assert maxConsecutiveAnswers(answerKeyThree, 1) == 5;
	}

	static int maxConsecutiveAnswers(String answerKey, int k) {
		final int n = answerKey.length();
		int l = 0;
		for (int i = 0, j = 0, tCnt = 0, fCnt = 0; j < n; j++) {
			if (answerKey.charAt(j) == TRUE)
				tCnt = tCnt + 1;
			else
				fCnt = fCnt + 1;
			while (Math.min(tCnt, fCnt) > k) {
				if (answerKey.charAt(i) == TRUE)
					tCnt = tCnt - 1;
				else
					fCnt = fCnt - 1;
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
