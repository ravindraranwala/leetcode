package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class MaximumProductOfSplittedBinaryTree {
	private static final int REM = 1000000007;

	MaximumProductOfSplittedBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxProduct(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), null))) == 110;

		assert maxProduct(new TreeNode(1, null,
				new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5), new TreeNode(6))))) == 90;
	}

	static int maxProduct(TreeNode root) {
		final int s = sumTree(root);
		final long[] a = { Long.MIN_VALUE };
		dfs(root, s, a);
		return (int) (a[0] % REM);
	}

	private static int sumTree(TreeNode root) {
		if (root == null)
			return 0;

		return sumTree(root.left) + sumTree(root.right) + root.val;
	}

	private static int dfs(TreeNode root, int s, long[] ans) {
		if (root == null)
			return 0;

		final int leftSum = dfs(root.left, s, ans);
		final long prd1 = leftSum * 1l * (s - leftSum);
		if (prd1 > ans[0])
			ans[0] = prd1;

		final int rightSum = dfs(root.right, s, ans);
		final long prd2 = rightSum * 1l * (s - rightSum);
		if (prd2 > ans[0])
			ans[0] = prd2;

		return leftSum + rightSum + root.val;
	}
}
