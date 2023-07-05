package com.coding.challenge.tree;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.bst.TreeNode;

class SmallestStringStartingFromLeaf {
	private static final Map<Integer, Character> charConverter = new HashMap<>();
	static {
		final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < 26; i++)
			charConverter.put(i, alphabet[i]);
	}

	SmallestStringStartingFromLeaf() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(0, new TreeNode(1, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(3), new TreeNode(4)));
		assert "dba".equals(smallestFromLeaf(rootOne));

		final TreeNode rootTwo = new TreeNode(25, new TreeNode(1, new TreeNode(1), new TreeNode(3)),
				new TreeNode(3, new TreeNode(0), new TreeNode(2)));
		assert "adz".equals(smallestFromLeaf(rootTwo));

		final TreeNode nodeThree = new TreeNode(2, new TreeNode(2, null, new TreeNode(1, new TreeNode(0), null)),
				new TreeNode(1, new TreeNode(0), null));
		assert "abc".equals(smallestFromLeaf(nodeThree));

		final TreeNode nodeFour = new TreeNode(4, new TreeNode(0, new TreeNode(1), null), new TreeNode(1));
		assert "bae".equals(smallestFromLeaf(nodeFour));

		final TreeNode rootFive = new TreeNode(25,
				new TreeNode(1, new TreeNode(0, new TreeNode(1, new TreeNode(0), null), null), new TreeNode(0)), null);
		assert "ababz".equals(smallestFromLeaf(rootFive));
	}

	static String smallestFromLeaf(TreeNode root) {
		return smallestStringFromLeaf(root, "");
	}

	private static String smallestStringFromLeaf(TreeNode root, String suffix) {
		// leaf node found.
		if (root.left == null && root.right == null)
			return charConverter.get(root.val) + suffix;
		else if (root.left == null)
			return smallestStringFromLeaf(root.right, charConverter.get(root.val) + suffix);
		else if (root.right == null)
			return smallestStringFromLeaf(root.left, charConverter.get(root.val) + suffix);
		else {
			final String l = smallestStringFromLeaf(root.left, charConverter.get(root.val) + suffix);
			final String r = smallestStringFromLeaf(root.right, charConverter.get(root.val) + suffix);
			return l.compareTo(r) < 0 ? l : r;
		}
	}
}
