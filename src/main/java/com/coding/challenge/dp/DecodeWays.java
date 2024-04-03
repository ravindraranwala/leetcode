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
		int beforePrev = 1;
		int prev = s.charAt(n - 1) == '0' ? 0 : 1;

		for (int i = n - 2; i >= 0; i--) {
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
