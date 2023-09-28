package com.coding.challenge.tree;

class VerifyPreorderSerializationOfBinaryTree {
	VerifyPreorderSerializationOfBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String t1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		assert isValidSerialization(t1);

		final String t2 = "1,#";
		assert !isValidSerialization(t2);

		final String t3 = "9,#,#,1";
		assert !isValidSerialization(t3);

		final String t4 = "1";
		assert !isValidSerialization(t4);
	}

	static boolean isValidSerialization(String preorder) {
		final int n = preorder.length();
		return visitTree(preorder, 0, n) == n - 1;
	}

	private static int visitTree(String s, int i, int n) {
		if (i >= n)
			return i;
		// trivial case of the recursion.
		if (s.charAt(i) == '#')
			return i;

		final int k = nextComma(s, i, n);
		// visit left sub-tree.
		final int j = visitTree(s, k + 1, n);
		// visit right sub-tree.
		final int l = nextComma(s, j, n);
		return visitTree(s, l + 1, n);
	}

	private static int nextComma(String s, int i, int n) {
		int k = i;
		while (k < n - 1 && s.charAt(k) != ',')
			k = k + 1;
		return k;
	}
}
