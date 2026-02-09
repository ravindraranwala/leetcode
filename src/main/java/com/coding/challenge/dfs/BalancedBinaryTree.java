package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class BalancedBinaryTree {
	BalancedBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		assert isBalanced(root1);

		final TreeNode root2 = new TreeNode(1,
				new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
		assert !isBalanced(root2);
		
		assert isBalanced(null);
	}

	static boolean isBalanced(TreeNode root) {
		final boolean[] ans = { true };
		dfs(root, ans);
		return ans[0];
	}

	private static int dfs(TreeNode root, boolean[] balanced) {
		if (root == null)
			return 0;

		final int leftDepth = dfs(root.left, balanced);
		final int rightDepth = dfs(root.right, balanced);
		balanced[0] = balanced[0] && Math.abs(leftDepth - rightDepth) <= 1;
		return Math.max(leftDepth, rightDepth) + 1;
	}
}
