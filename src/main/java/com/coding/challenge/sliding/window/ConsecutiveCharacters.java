package com.coding.challenge.sliding.window;

class ConsecutiveCharacters {
	ConsecutiveCharacters() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxPower("leetcode") == 2;
		assert maxPower("abbcccddddeeeeedcba") == 5;
	}

	static int maxPower(String s) {
		final int n = s.length();
		int l = 1;
		for (int i = 1, start = 0; i < n; i++) {
			if (s.charAt(i) != s.charAt(i - 1))
				start = i;
			l = Math.max(l, i - start + 1);
		}
		return l;
	}
}
