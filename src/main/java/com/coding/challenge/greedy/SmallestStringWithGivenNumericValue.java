package com.coding.challenge.greedy;

class SmallestStringWithGivenNumericValue {
	SmallestStringWithGivenNumericValue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "aay".equals(getSmallestString(3, 27));
		assert "aaszz".equals(getSmallestString(5, 73));
	}

	static String getSmallestString(int n, int k) {
		final char[] chars = new char[n];
		final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		for (int i = n; i > 0; i--) {
			final int j = Math.min(k - n + 1, 26);
			chars[i - 1] = alphabet[j - 1];
			n = n - 1;
			k = k - j;
		}
		return new String(chars);
	}
}
