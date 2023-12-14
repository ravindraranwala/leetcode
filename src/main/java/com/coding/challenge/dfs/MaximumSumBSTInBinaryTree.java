package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class MaximumSumBSTInBinaryTree {
	MaximumSumBSTInBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(1, new TreeNode(4, new TreeNode(2), new TreeNode(4)),
				new TreeNode(3, new TreeNode(2), new TreeNode(5, new TreeNode(4), new TreeNode(6))));
		assert maxSumBST(r1) == 20;

		final TreeNode r2 = new TreeNode(4, new TreeNode(3, new TreeNode(1), new TreeNode(2)), null);
		assert maxSumBST(r2) == 2;

		final TreeNode r3 = new TreeNode(-4, new TreeNode(-2), new TreeNode(-5));
		assert maxSumBST(r3) == 0;

		final TreeNode r4 = new TreeNode(1, null, new TreeNode(10, new TreeNode(-5), new TreeNode(20)));
		assert maxSumBST(r4) == 25;
	}

	static int maxSumBST(TreeNode root) {
		final int[] a = new int[1];
		visitTree(root, a);
		return a[0];
	}

	private static int[] visitTree(TreeNode node, int[] a) {
		if (node == null)
			return new int[] { 1, 100000, -100000, 0 };

		final int[] left = visitTree(node.left, a);
		final int[] right = visitTree(node.right, a);
		final int sum = left[3] + right[3] + node.val;
		final boolean isBst = left[0] == 1 && left[2] < node.val && right[0] == 1 && right[1] > node.val;
		if (isBst)
			a[0] = Math.max(a[0], sum);
		final int treeMin = Math.min(node.val, Math.min(left[1], right[1]));
		final int treeMax = Math.max(node.val, Math.max(left[2], right[2]));
		return new int[] { isBst ? 1 : 0, treeMin, treeMax, sum };
	}
}
