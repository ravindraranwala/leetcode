package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class InvertBinaryTree {
	InvertBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
				new TreeNode(7, new TreeNode(6), new TreeNode(9)));
		assert "[9, 7, 6, 4, 3, 2, 1]".equals(invertTree(root1).toString());

		assert "[3, 2, 1]".equals(invertTree(new TreeNode(2, new TreeNode(1), new TreeNode(3))).toString());
	}

	static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;

		invertTree(root.left);
		invertTree(root.right);
		final TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
}
