package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class KthSmallestElementInBST {
	KthSmallestElementInBST() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
		assert kthSmallest(r1, 1) == 1;

		final TreeNode r2 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
				new TreeNode(6));
		assert kthSmallest(r2, 3) == 3;
	}

	static int kthSmallest(TreeNode root, int k) {
		final int[] a = new int[2];
		visitTree(root, a, k);
		return a[1];
	}

	private static void visitTree(TreeNode node, int[] a, int k) {
		if (node == null)
			return;
		// in-order tree traversal.
		visitTree(node.left, a, k);
		a[0] = a[0] + 1;
		if (a[0] == k)
			a[1] = node.val;
		visitTree(node.right, a, k);
	}
}
