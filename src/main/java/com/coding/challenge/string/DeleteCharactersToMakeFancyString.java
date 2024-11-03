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
		final StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		if (n > 1)
			sb.append(s.charAt(1));
		for (int i = 2; i < n; i++)
			if (s.charAt(i - 2) != s.charAt(i - 1) || s.charAt(i - 1) != s.charAt(i))
				sb.append(s.charAt(i));

		return sb.toString();
	}
}
