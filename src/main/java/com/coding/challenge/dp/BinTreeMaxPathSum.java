package com.coding.challenge.dp;

import com.coding.challenge.bst.TreeNode;

class BinTreeMaxPathSum {
	BinTreeMaxPathSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		assert maxPathSum(rootOne) == 6;

		final TreeNode rootTwo = new TreeNode(-10, new TreeNode(9),
				new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		assert maxPathSum(rootTwo) == 42;

		final TreeNode rootThree = new TreeNode(-3);
		assert maxPathSum(rootThree) == -3;
	}

	static int maxPathSum(TreeNode root) {
		final int[] ans = { -2000 };
		maxPathSum(root, ans);
		return ans[0];
	}

	private static int maxPathSum(TreeNode root, int[] ans) {
		// base-case of the recursion.
		if (root == null)
			return 0;
		
		final int l = maxPathSum(root.left, ans);
		final int r = maxPathSum(root.right, ans);
		final int p = Math.max(Math.max(l, r) + root.val, root.val);
		ans[0] = Math.max(ans[0], Math.max(p, l + r + root.val));
		return p;
	}
}
