package com.coding.challenge.tree;

class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
	private static final char FIRST_LETTER = 'a';

	TheKthLexicographicalStringOfAllHappyStringsOfLengthN() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "c".equals(getHappyString(1, 3));
		assert "".equals(getHappyString(1, 4));
		assert "cab".equals(getHappyString(3, 9));
	}

	static String getHappyString(int n, int k) {
		final int leavesPerTree = (int) Math.pow(2, n - 1);
		if (k > 3 * leavesPerTree)
			return "";

		// zero based indices.
		final int i = (k - 1) / leavesPerTree;
		final char[] ans = new char[n];
		ans[0] = (char) (FIRST_LETTER + i);
		final char[][] children = { { 'b', 'c' }, { 'a', 'c' }, { 'a', 'b' } };
		for (int j = 1, rank = k - i * leavesPerTree, parentLeaves = leavesPerTree; j < n; j++) {
			final char prevCh = ans[j - 1];
			if (rank <= parentLeaves / 2)
				// take the left subtree.
				ans[j] = children[prevCh - FIRST_LETTER][0];
			else {
				// take the right subtree.
				ans[j] = children[prevCh - FIRST_LETTER][1];
				// skipping half of the perfect binary tree rooted at the parent node.
				rank = rank - parentLeaves / 2;
			}
			parentLeaves = parentLeaves / 2;
		}
		return new String(ans);
	}
}
