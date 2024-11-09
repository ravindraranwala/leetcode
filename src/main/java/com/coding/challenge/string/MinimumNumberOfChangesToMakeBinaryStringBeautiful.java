package com.coding.challenge.string;

class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
	MinimumNumberOfChangesToMakeBinaryStringBeautiful() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minChanges("1001") == 2;
		assert minChanges("10") == 1;
		assert minChanges("0000") == 0;
	}

	static int minChanges(String s) {
		int c = 0;
		char startCh = '2';
		int l = 0;
		for (char ch : s.toCharArray()) {
			if (ch == startCh)
				l = l + 1;
			else {
				final int r = l % 2;
				c = c + r;
				l = r + 1;
				startCh = ch;
			}
		}
		return c;
	}
}
