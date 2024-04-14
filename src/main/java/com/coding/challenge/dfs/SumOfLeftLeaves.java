package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class SumOfLeftLeaves {
	SumOfLeftLeaves() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		assert sumOfLeftLeaves(root1) == 24;

		assert sumOfLeftLeaves(new TreeNode(1)) == 0;
	}

	static int sumOfLeftLeaves(TreeNode root) {
		return dfs(root, false);
	}

	private static int dfs(TreeNode root, boolean leftChild) {
		if (root == null)
			return 0;
		// leaf node.
		if (root.left == null && root.right == null && leftChild)
			return root.val;

		return dfs(root.left, true) + dfs(root.right, false);
	}
}
