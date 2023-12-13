package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class BinaryTreePruning {
	BinaryTreePruning() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)));
		assert "[1, 0, 1]".equals(pruneTree(r1).toString());

		final TreeNode r2 = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(0)),
				new TreeNode(1, new TreeNode(0), new TreeNode(1)));
		assert "[1, 1, 1]".equals(pruneTree(r2).toString());

		final TreeNode r3 = new TreeNode(1, new TreeNode(1, new TreeNode(1, new TreeNode(0), null), new TreeNode(1)),
				new TreeNode(0, new TreeNode(0), new TreeNode(1)));
		assert "[1, 1, 1, 1, 0, 1]".equals(pruneTree(r3).toString());
	}

	static TreeNode pruneTree(TreeNode root) {
		if (!visitTree(root))
			return null;
		return root;
	}

	private static boolean visitTree(TreeNode node) {
		if (node == null)
			return false;
		final boolean left = visitTree(node.left);
		if (!left)
			node.left = null;
		final boolean right = visitTree(node.right);
		if (!right)
			node.right = null;
		return left || right || node.val == 1;
	}
}
