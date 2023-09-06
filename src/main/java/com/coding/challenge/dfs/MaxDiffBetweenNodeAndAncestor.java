package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class MaxDiffBetweenNodeAndAncestor {
	MaxDiffBetweenNodeAndAncestor() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(8,
				new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
				new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
		assert maxAncestorDiff(rootOne) == 7;

		final TreeNode rootTwo = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));
		assert maxAncestorDiff(rootTwo) == 3;
	}

	static int maxAncestorDiff(TreeNode root) {
		final int[] ans = new int[1];
		visitTree(root, ans, 0);
		return ans[0];
	}

	private static int[] visitTree(TreeNode node, int[] ans, int parentKey) {
		if (node == null)
			return new int[] { parentKey, parentKey };
		final int[] l = visitTree(node.left, ans, node.val);
		final int[] r = visitTree(node.right, ans, node.val);
		final int min = Math.min(l[0], r[0]);
		final int max = Math.max(l[1], r[1]);
		final int diff = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));
		ans[0] = Math.max(ans[0], diff);
		return new int[] { Math.min(min, node.val), Math.max(max, node.val) };
	}
}
