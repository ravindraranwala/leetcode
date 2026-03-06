package com.coding.challenge.string;

class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
	private static final char ONE = '1';

	CheckIfBinaryStringHasAtMostOneSegmentOfOnes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert !checkOnesSegment("1001");
		assert checkOnesSegment("110");
		assert checkOnesSegment("0000000000");
	}

	static boolean checkOnesSegment(String s) {
		int c = 0;
		final int n = s.length();
		int i = 0;
		while (i < n) {
			if (s.charAt(i) == ONE) {
				while (i < n && s.charAt(i) == ONE)
					i = i + 1;
				c = c + 1;
			} else
				i = i + 1;
		}
		return c <= 1;
	}
}
