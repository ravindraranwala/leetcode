package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class SmallestSubtreeWithAllTheDeepestNodes {
	SmallestSubtreeWithAllTheDeepestNodes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3,
				new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
				new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		System.out.println(subtreeWithAllDeepest(root1));

		System.out.println(subtreeWithAllDeepest(new TreeNode(1)));

		final TreeNode root2 = new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3));
		System.out.println(subtreeWithAllDeepest(root2));
	}

	static TreeNode subtreeWithAllDeepest(TreeNode root) {
		final TreeNode[] ans = new TreeNode[1];
		dfs(root, -1, new int[1], ans);
		return ans[0];
	}

	private static int dfs(TreeNode root, int ph, int[] h, TreeNode[] ans) {
		if (root == null)
			return ph;

		final int lh = dfs(root.left, ph + 1, h, ans);
		final int rh = dfs(root.right, ph + 1, h, ans);

		if (lh == rh && lh >= h[0]) {
			h[0] = lh;
			ans[0] = root;
		}

		return Math.max(lh, rh);
	}
}
