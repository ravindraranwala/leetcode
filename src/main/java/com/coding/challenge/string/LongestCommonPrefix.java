package com.coding.challenge.string;

class LongestCommonPrefix {
	LongestCommonPrefix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] strs1 = { "flower", "flow", "flight" };
		assert "fl".equals(longestCommonPrefix(strs1));

		final String[] strs2 = { "dog", "racecar", "car" };
		assert "".equals(longestCommonPrefix(strs2));
	}

	static String longestCommonPrefix(String[] strs) {
		int shortestLen = strs[0].length();
		for (String s : strs)
			shortestLen = Math.min(shortestLen, s.length());

		int l = 0;
		for (int i = 0; i < shortestLen; i++) {
			final char ch = strs[0].charAt(i);
			for (String s : strs)
				if (s.charAt(i) != ch)
					return strs[0].substring(0, l);
			l = l + 1;
		}
		return strs[0].substring(0, l);
	}
}
