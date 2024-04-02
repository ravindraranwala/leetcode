package com.coding.challenge.hash.table;

class IsomorphicStrings {
	IsomorphicStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isIsomorphic("egg", "add");
		assert !isIsomorphic("foo", "bar");
		assert isIsomorphic("paper", "title");
		assert !isIsomorphic("badc", "baba");
	}

	static boolean isIsomorphic(String s, String t) {
		final int n = s.length();
		final int[] mapping = new int[128];
		final int[] reverseMapping = new int[128];
		for (int i = 0; i < 128; i++) {
			mapping[i] = -1;
			reverseMapping[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			final char ch1 = s.charAt(i);
			final char ch2 = t.charAt(i);
			if (mapping[ch1] == -1)
				mapping[ch1] = ch2;
			else if (mapping[ch1] != ch2)
				return false;

			if (reverseMapping[ch2] == -1)
				reverseMapping[ch2] = ch1;
			else if (reverseMapping[ch2] != ch1)
				return false;
		}
		return true;
	}
}
