package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class LowestCommonAncestorOfDeepestLeaves {
	private int maxDepth = 0;
	private TreeNode lca = null;

	LowestCommonAncestorOfDeepestLeaves() {

	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3,
				new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
				new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		System.out.println(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(root1));

		System.out.println(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(new TreeNode(1)));

		final TreeNode root2 = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3));
		System.out.println(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(root2));
	}

	TreeNode lcaDeepestLeaves(TreeNode root) {
		dfsVisit(root, 0);
		return lca;
	}

	private int dfsVisit(TreeNode root, int d) {
		if (root == null)
			return d - 1;

		final int leftDepth = dfsVisit(root.left, d + 1);
		final int rightDepth = dfsVisit(root.right, d + 1);
		if (leftDepth == rightDepth && leftDepth >= maxDepth) {
			lca = root;
			maxDepth = leftDepth;
		}
		return Math.max(leftDepth, rightDepth);
	}
}
