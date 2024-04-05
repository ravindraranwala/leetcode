package com.coding.challenge.dp;

class DecodeWaysII {
	private static final int REM = 1000000007;

	DecodeWaysII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numDecodings("*") == 9;
		assert numDecodings("1*") == 18;
		assert numDecodings("2*") == 15;
		assert numDecodings("1201234") == 3;
		assert numDecodings("10") == 1;
	}

	static int numDecodings(String s) {
		final int n = s.length();
		int beforePrev = 1;
		int prev = 0;
		if (s.charAt(n - 1) == '*')
			prev = 9;
		else if (s.charAt(n - 1) != '0')
			prev = 1;

		for (int i = n - 2; i >= 0; i--) {
			int d = 0;
			final char curr = s.charAt(i);
			final char next = s.charAt(i + 1);
			if (curr == '*') {
				if (next == '*')
					d = (int) (((9l * prev % REM) + (15l * beforePrev % REM)) % REM);
				else if (next - '0' <= 6)
					d = (int) (((9l * prev % REM) + (2l * beforePrev % REM)) % REM);
				else
					d = (int) (((9l * prev % REM) + beforePrev) % REM);
			} else if (curr - '0' > 0) {
				if (next == '*') {
					if (curr == '1')
						d = (int) ((prev + (9l * beforePrev % REM)) % REM);
					else if (curr == '2')
						d = (int) ((prev + (6l * beforePrev % REM)) % REM);
					else
						d = prev;
				} else {
					final int val = (curr - '0') * 10 + (next - '0');
					if (val > 26)
						d = prev;
					else
						d = (prev + beforePrev) % REM;
				}
			}
			beforePrev = prev;
			prev = d;
		}
		return prev;
	}
}
