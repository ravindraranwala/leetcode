package com.coding.challenge.tree;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class MaximumLevelSumOfBinaryTree {
	MaximumLevelSumOfBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
		assert maxLevelSum(rootOne) == 2;

		final TreeNode rootTwo = new TreeNode(989, null,
				new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388, null, new TreeNode(-32127))));
		assert maxLevelSum(rootTwo) == 2;

		final TreeNode rootThree = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		assert maxLevelSum(rootThree) == 2;
	}

	static int maxLevelSum(TreeNode root) {
		final List<Integer> levelSum = new ArrayList<>();
		visitTree(root, 0, levelSum);
		int l = 0;
		final int n = levelSum.size();
		for (int i = 1; i < n; i++)
			if (levelSum.get(i) > levelSum.get(l))
				l = i;
		return l + 1;
	}

	private static void visitTree(TreeNode node, int level, List<Integer> levelSum) {
		if (node == null)
			return;
		if (levelSum.size() > level)
			levelSum.set(level, levelSum.get(level) + node.val);
		else
			levelSum.add(node.val);
		visitTree(node.left, level + 1, levelSum);
		visitTree(node.right, level + 1, levelSum);
	}
}
