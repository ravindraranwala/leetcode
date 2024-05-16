package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class EvaluateBooleanBinaryTree {
	EvaluateBooleanBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(1)));
		assert evaluateTree(root1);

		assert !evaluateTree(new TreeNode(0));
	}

	static boolean evaluateTree(TreeNode root) {
		if (root.left == null && root.right == null)
			return root.val == 1;

		final boolean left = evaluateTree(root.left);
		final boolean right = evaluateTree(root.right);
		if (root.val == 2)
			return left || right;
		else
			return left && right;
	}
}
