package com.coding.challenge.greedy;

class LargestMergeOfTwoStrings {
	LargestMergeOfTwoStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "cbcabaaaaa".equals(largestMerge("cabaa", "bcaaa"));
		assert "abdcabcabcaba".equals(largestMerge("abcabc", "abdcaba"));
		assert "eeddchca".equals(largestMerge("edch", "edca"));
	}

	static String largestMerge(String word1, String word2) {
		final int m = word1.length();
		final int n = word2.length();
		int i = 0;
		int j = 0;
		final StringBuilder s = new StringBuilder();
		while (i < m && j < n) {
			final boolean first = largerSubString(word1, word2, i, j) == 1;
			if (first) {
				s.append(word1.charAt(i));
				i = i + 1;
			} else {
				s.append(word2.charAt(j));
				j = j + 1;
			}
		}
		// handle remaining chars if any.
		while (i < m) {
			s.append(word1.charAt(i));
			i = i + 1;
		}
		while (j < n) {
			s.append(word2.charAt(j));
			j = j + 1;
		}
		return s.toString();
	}

	/*
	 * use of constant space solution over substring method which takes linear
	 * space.
	 */
	private static int largerSubString(String word1, String word2, int i, int j) {
		final int m = word1.length();
		final int n = word2.length();
		while (i < m && j < n) {
			if (word1.charAt(i) == word2.charAt(j)) {
				i = i + 1;
				j = j + 1;
			} else if (word1.charAt(i) < word2.charAt(j))
				return 2;
			else
				return 1;
		}
		return i == m ? 2 : 1;
	}
}
