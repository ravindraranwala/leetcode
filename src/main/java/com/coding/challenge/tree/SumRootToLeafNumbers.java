package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class SumRootToLeafNumbers {
	SumRootToLeafNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		assert sumNumbers(rootOne) == 25;

		final TreeNode rootTwo = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
		assert sumNumbers(rootTwo) == 1026;

		final TreeNode rootThree = new TreeNode(0, new TreeNode(1), null);
		assert sumNumbers(rootThree) == 1;
	}

	static int sumNumbers(TreeNode root) {
		return pathSum(root, 0);
	}

	static int pathSum(TreeNode node, int parentSum) {
		if (node == null)
			return 0;
		final int currSum = parentSum * 10 + node.val;
		// leaf node found.
		if (node.left == null && node.right == null)
			return currSum;
		return pathSum(node.left, currSum) + pathSum(node.right, currSum);
	}
}
