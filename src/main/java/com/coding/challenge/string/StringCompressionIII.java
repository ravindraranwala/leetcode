package com.coding.challenge.string;

class StringCompressionIII {
	StringCompressionIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "1a1b1c1d1e".equals(compressedString("abcde"));
		assert "9a5a2b".equals(compressedString("aaaaaaaaaaaaaabb"));
		assert "9a1y".equals(compressedString("aaaaaaaaay"));
	}

	static String compressedString(String word) {
		final int n = word.length();
		int f = 1;
		final StringBuilder comp = new StringBuilder();

		for (int i = 1; i < n; i++) {
			if (word.charAt(i) != word.charAt(i - 1)) {
				generateOutput(comp, f, word.charAt(i - 1));
				f = 0;
			}
			f = f + 1;
		}
		generateOutput(comp, f, word.charAt(n - 1));
		return comp.toString();
	}

	private static void generateOutput(StringBuilder sb, int f, char ch) {
		final int n = f / 9;
		for (int i = 0; i < n; i++)
			sb.append(9).append(ch);
		if (f % 9 > 0)
			sb.append(f % 9).append(ch);
	}
}
