package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class MinimumAbsoluteDifferenceInBST {
	int prev = -100001;
	int d = 100001;

	MinimumAbsoluteDifferenceInBST() {

	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
		assert new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root1) == 1;

		final TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
		assert new MinimumAbsoluteDifferenceInBST().getMinimumDifference(root2) == 1;

		assert new MinimumAbsoluteDifferenceInBST().getMinimumDifference(new TreeNode(1, null, new TreeNode(2))) == 1;

		assert new MinimumAbsoluteDifferenceInBST()
				.getMinimumDifference(new TreeNode(0, null, new TreeNode(100000))) == 100000;
	}

	int getMinimumDifference(TreeNode root) {
		minDiff(root);
		return d;
	}

	private void minDiff(TreeNode root) {
		if (root == null)
			return;
		minDiff(root.left);
		d = Math.min(d, root.val - prev);
		prev = root.val;
		minDiff(root.right);
	}
}
