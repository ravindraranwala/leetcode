package com.coding.challenge.greedy;

class MaximumNumberOfOperationsToMoveOnesToTheEnd {
	MaximumNumberOfOperationsToMoveOnesToTheEnd() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxOperations("1001101") == 4;
		assert maxOperations("00111") == 0;
		assert maxOperations("100101000") == 6;
	}

	static int maxOperations(String s) {
		final int n = s.length();
		int c = 0;
		for (int i = n - 1, allZeroSubarrs = 0, lastZeroIdx = -1; i >= 0; i--) {
			if (s.charAt(i) == '1')
				c = c + allZeroSubarrs;
			else {
				if (lastZeroIdx != i + 1)
					allZeroSubarrs = allZeroSubarrs + 1;

				lastZeroIdx = i;
			}
		}
		return c;
	}
}
