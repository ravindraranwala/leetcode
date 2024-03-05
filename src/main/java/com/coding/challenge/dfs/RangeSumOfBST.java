package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class RangeSumOfBST {
	RangeSumOfBST() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)),
				new TreeNode(15, null, new TreeNode(18)));
		assert rangeSumBST(root1, 7, 15) == 32;

		final TreeNode root2 = new TreeNode(10,
				new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)),
				new TreeNode(15, new TreeNode(13), new TreeNode(18)));
		assert rangeSumBST(root2, 6, 10) == 23;
	}

	static int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;
		final int leftSum = rangeSumBST(root.left, low, high);
		final int rightSum = rangeSumBST(root.right, low, high);
		if (low <= root.val && root.val <= high)
			return leftSum + rightSum + root.val;

		return leftSum + rightSum;
	}
}
