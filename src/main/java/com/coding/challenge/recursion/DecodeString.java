package com.coding.challenge.recursion;

class DecodeString {
	DecodeString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "aaabcbc".equals(decodeString("3[a]2[bc]"));
		assert "accaccacc".equals(decodeString("3[a2[c]]"));
		assert "abcabccdcdcdef".equals(decodeString("2[abc]3[cd]ef"));
	}

	static String decodeString(String s) {
		return decode("1[" + s + "]", 0, new int[1]);
	}

	private static String decode(String s, int i, int[] a) {
		int k = i;
		final int n = s.length();
		while (k < n && Character.isDigit(s.charAt(k)))
			k = k + 1;

		final int repetition = Integer.parseInt(s.substring(i, k));
		final StringBuilder ans = new StringBuilder();
		while (k < n && s.charAt(k) != ']') {
			final char ch = s.charAt(k);
			if (Character.isDigit(ch)) {
				ans.append(decode(s, k, a));
				k = a[0];
			} else if (ch != '[')
				ans.append(ch);
			k = k + 1;
		}
		
		a[0] = k;
		final String original = ans.toString();
		for (int j = 1; j < repetition; j++)
			ans.append(original);
		return ans.toString();
	}
}
