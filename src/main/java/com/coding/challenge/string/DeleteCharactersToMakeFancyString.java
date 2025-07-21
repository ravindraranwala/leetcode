package com.coding.challenge.string;

class DeleteCharactersToMakeFancyString {
	DeleteCharactersToMakeFancyString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "leetcode".equals(makeFancyString("leeetcode"));
		assert "aabaa".equals(makeFancyString("aaabaaaa"));
		assert "aab".equals(makeFancyString("aab"));
	}

	static String makeFancyString(String s) {
		final int n = s.length();
		final StringBuilder ans = new StringBuilder();
		ans.append(s.charAt(0));

		for (int i = 1, c = 1; i < n; i++) {
			final char ch = s.charAt(i);
			if (ch == s.charAt(i - 1))
				c = c + 1;
			else
				c = 1;

			if (c < 3)
				ans.append(ch);
		}
		return ans.toString();
	}
}
