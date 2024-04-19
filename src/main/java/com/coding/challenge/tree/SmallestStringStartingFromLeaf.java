package com.coding.challenge.tree;

import java.util.Arrays;

import com.coding.challenge.bst.TreeNode;

class SmallestStringStartingFromLeaf {
	private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final int LEN = 8500;
	// identity element for smallest alphabetical string.
	private String str = "~";
	private char[] curr = new char[LEN];

	SmallestStringStartingFromLeaf() {
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(3), new TreeNode(4)));
		assert "dba".equals(new SmallestStringStartingFromLeaf().smallestFromLeaf(rootOne));

		final TreeNode rootTwo = new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)),
				new TreeNode(3, new TreeNode(0), new TreeNode(2)));
		assert "adz".equals(new SmallestStringStartingFromLeaf().smallestFromLeaf(rootTwo));

		final TreeNode nodeThree = new TreeNode(2, new TreeNode(2, null, new TreeNode(1, new TreeNode(0), null)),
				new TreeNode(1, new TreeNode(0), null));
		assert "abc".equals(new SmallestStringStartingFromLeaf().smallestFromLeaf(nodeThree));

		final TreeNode nodeFour = new TreeNode(4, new TreeNode(0, new TreeNode(1), null), new TreeNode(1));
		assert "bae".equals(new SmallestStringStartingFromLeaf().smallestFromLeaf(nodeFour));

		final TreeNode rootFive = new TreeNode(25,
				new TreeNode(1, new TreeNode(0, new TreeNode(1, new TreeNode(0), null), null), new TreeNode(0)), null);
		assert "ababz".equals(new SmallestStringStartingFromLeaf().smallestFromLeaf(rootFive));
	}

	String smallestFromLeaf(TreeNode root) {
		dfs(root, 0);
		return str;
	}

	private void dfs(TreeNode root, int l) {
		if (root == null)
			return;
		curr[LEN - l - 1] = ALPHABET[root.val];
		// leaf node found.
		if (root.left == null && root.right == null) {
			final String p = new String(Arrays.copyOfRange(curr, LEN - l - 1, LEN));
			if (p.compareTo(str) < 0)
				str = p;
		} else {
			dfs(root.left, l + 1);
			dfs(root.right, l + 1);
		}
	}
}
