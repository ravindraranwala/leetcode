package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class DeleteLeavesWithGivenValue {
	DeleteLeavesWithGivenValue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(1, new TreeNode(2, new TreeNode(2), null),
				new TreeNode(3, new TreeNode(2), new TreeNode(4)));
		assert "[1, 3, 4]".equals(removeLeafNodes(r1, 2).toString());

		final TreeNode r2 = new TreeNode(1, new TreeNode(3, new TreeNode(3), new TreeNode(2)), new TreeNode(3));
		assert "[3, 2, 1]".equals(removeLeafNodes(r2, 3).toString());

		final TreeNode r3 = new TreeNode(1, new TreeNode(2, new TreeNode(2, new TreeNode(2), null), null), null);
		assert "[1]".equals(removeLeafNodes(r3, 2).toString());

		final TreeNode r4 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
		assert removeLeafNodes(r4, 2) == null;
	}

	static TreeNode removeLeafNodes(TreeNode root, int target) {
		if (removeLeaves(root, target))
			return null;
		return root;
	}

	private static boolean removeLeaves(TreeNode p, int target) {
		if (p == null)
			return true;

		if (removeLeaves(p.left, target))
			p.left = null;
		if (removeLeaves(p.right, target))
			p.right = null;
		return p.left == null && p.right == null && p.val == target;
	}
}
