package com.coding.challenge.dp;

class RegexMatcher {
	RegexMatcher() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s1 = "aa";
		final String p1 = "a";
		boolean match = isMatch(s1, p1);
		System.out.println(match);

		final String s2 = "aa";
		final String p2 = "a*";
		match = isMatch(s2, p2);
		System.out.println(match);

		final String s3 = "ab";
		final String p3 = ".*";
		match = isMatch(s3, p3);
		System.out.println(match);

		final String s4 = "aab";
		final String p4 = "c*a*b";
		match = isMatch(s4, p4);
		System.out.println(match);

		final String s5 = "mississippi";
		final String p5 = "mis*is*p*.";
		match = isMatch(s5, p5);
		System.out.println(match);

		final String s6 = "aaa";
		final String p6 = "ab*ac*a";
		match = isMatch(s6, p6);
		System.out.println(match);

		final String s7 = "aaa";
		final String p7 = "ab*a*c*a";
		match = isMatch(s7, p7);
		System.out.println(match);

		final String s8 = "ababacd";
		final String p8 = ".*";
		match = isMatch(s8, p8);
		System.out.println(match);

		final String s9 = "aasdfasdfasdfasdfas";
		final String p9 = "aasdf.*asdf.*asdf.*asdf.*s";
		match = isMatch(s9, p9);
		System.out.println(match);

		final String s10 = "aaa";
		final String p10 = "a*";
		match = isMatch(s10, p10);
		System.out.println(match);
	}

	static boolean isMatch(String s, String p) {
		final int m = s.length();
		final int n = p.length();
		final boolean[][] t = new boolean[m + 1][n + 1];
		t[0][0] = true;
		for (int i = 1; i <= m; i++)
			t[i][0] = false;
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) == '*')
				t[0][j] = t[0][j - 2];
			else
				t[0][j] = false;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == '*') {
					if (t[i][j - 2] || t[i][j - 1])
						t[i][j] = true;
					else
						t[i][j] = t[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1));
				} else
					t[i][j] = t[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
			}
		}
		return t[m][n];
	}
}
