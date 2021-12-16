package com.coding.challenge.dp;

class WildcardMatching {
	WildcardMatching() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s1 = "aa";
		final String p1 = "a";
		boolean m = isMatch(s1, p1);
		System.out.println(m);
		
		final String s2 = "aa";
		final String p2 = "*";
		m = isMatch(s2, p2);
		System.out.println(m);
		
		final String s3 = "cb";
		final String p3 = "?a";
		m = isMatch(s3, p3);
		System.out.println(m);
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
				t[0][j] = t[0][j - 1];
			else
				t[0][j] = false;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == '*') {
					if (t[i][j - 1] || t[i - 1][j - 1])
						t[i][j] = true;
					else
						t[i][j] = t[i - 1][j];
				} else
					t[i][j] = t[i - 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1));
			}
		}
		return t[m][n];
	}
}
