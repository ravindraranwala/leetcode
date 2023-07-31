package com.coding.challenge.dp;

import com.coding.challenge.bst.TreeNode;

class BinaryTreeLongestZigZagPath {
	BinaryTreeLongestZigZagPath() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode treeOne = new TreeNode(1, null, new TreeNode(1, new TreeNode(1),
				new TreeNode(1, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))), new TreeNode(1))));
		assert longestZigZag(treeOne) == 3;

		final TreeNode treeTwo = new TreeNode(1,
				new TreeNode(1, null, new TreeNode(1, new TreeNode(1, null, new TreeNode(1)), new TreeNode(1))),
				new TreeNode(1));
		assert longestZigZag(treeTwo) == 4;

		assert longestZigZag(new TreeNode(1)) == 0;
	}

	static int longestZigZag(TreeNode root) {
		final int[] a = new int[1];
		longestZigZagPath(root, a);
		return a[0];
	}

	private static int[] longestZigZagPath(TreeNode node, int[] a) {
		if (node == null)
			return new int[] { -1, -1 };

		final int[] p = new int[2];
		final int[] l = longestZigZagPath(node.left, a);
		p[0] = l[1] + 1;
		final int[] r = longestZigZagPath(node.right, a);
		p[1] = r[0] + 1;
		a[0] = Math.max(a[0], Math.max(p[0], p[1]));
		return p;
	}
}
