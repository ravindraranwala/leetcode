package com.coding.challenge.greedy;

class SeparateBlackAndWhiteBalls {
	SeparateBlackAndWhiteBalls() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumSteps("101") == 1;
		assert minimumSteps("100") == 2;
		assert minimumSteps("0111") == 0;
	}

	static long minimumSteps(String s) {
		final int n = s.length();
		long swaps = 0;
		for (int i = n - 1, nextBlackIdx = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '1') {
				swaps = swaps + nextBlackIdx - i;
				nextBlackIdx = nextBlackIdx - 1;
			}
		}
		return swaps;
	}
}
