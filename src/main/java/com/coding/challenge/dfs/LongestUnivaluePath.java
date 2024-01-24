package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class LongestUnivaluePath {
	LongestUnivaluePath() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)),
				new TreeNode(5, null, new TreeNode(5)));
		assert longestUnivaluePath(root1) == 2;

		final TreeNode root2 = new TreeNode(1, new TreeNode(4, new TreeNode(4), new TreeNode(4)),
				new TreeNode(5, null, new TreeNode(5)));
		assert longestUnivaluePath(root2) == 2;

		assert longestUnivaluePath(null) == 0;

		final TreeNode root3 = new TreeNode(1, null, new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)),
				new TreeNode(1, new TreeNode(1), null)));
		assert longestUnivaluePath(root3) == 4;
	}

	static int longestUnivaluePath(TreeNode root) {
		final int[] a = new int[1];
		visitTree(root, a, -1);
		return a[0];
	}

	private static int visitTree(TreeNode root, int[] a, int parent) {
		if (root == null)
			return 0;

		final int left = visitTree(root.left, a, root.val);
		final int right = visitTree(root.right, a, root.val);
		a[0] = Math.max(a[0], left + right);
		return root.val == parent ? Math.max(left, right) + 1 : 0;
	}
}
