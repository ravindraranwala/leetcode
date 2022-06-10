package com.coding.challenge.dp;

class VowelsOfAllSubstrings {
	VowelsOfAllSubstrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {

	}

	static long countVowels(String word) {
		final int n = word.length();
		final int[][] v = new int[n][n];
		int c = 0;
		// trivial case of the recursion, calculating the diagonal entries in the table
		for (int i = 0; i < n; i++) {
			final char ch = word.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
				v[i][i] = 1;
			else
				v[i][i] = 0;
			c = c + v[i][i];
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				final char ch = word.charAt(j);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
					v[i][j] = v[i][j - 1] + 1;
				else
					v[i][j] = v[i][j - 1];
				
				c = c + v[i][j];
			}
		}
		return c;
	}
}
