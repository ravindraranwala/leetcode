package com.coding.challenge.dp;

class DecodeWays {
	DecodeWays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numDecodings("12") == 2;
		assert numDecodings("226") == 3;
		assert numDecodings("06") == 0;
		assert numDecodings("4") == 1;
		assert numDecodings("10") == 1;
		assert numDecodings("27") == 1;
		assert numDecodings("1201234") == 3;
	}

	static int numDecodings(String s) {
		final int n = s.length();
		if (n == 1)
			return s.charAt(0) == '0' ? 0 : 1;
		int beforePrev = s.charAt(n - 1) == '0' ? 0 : 1;
		int prev = 0;
		if (s.charAt(n - 2) != '0') {
			final int val = (s.charAt(n - 2) - '0') * 10 + (s.charAt(n - 1) - '0');
			if (val > 26)
				prev = beforePrev;
			else
				prev = beforePrev + 1;
		}

		for (int i = n - 3; i >= 0; i--) {
			int d = 0;
			if (s.charAt(i) != '0') {
				final int val = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
				if (val > 26)
					d = prev;
				else
					d = prev + beforePrev;
			}
			beforePrev = prev;
			prev = d;
		}
		return prev;
	}
}
