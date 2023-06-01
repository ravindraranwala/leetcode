package com.coding.challenge.tree;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.bst.TreeNode;
import com.coding.challenge.quick.select.GenericQuickSelect;

class KthLargestBinaryTreeLevelSum {
	KthLargestBinaryTreeLevelSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(5,
				new TreeNode(8, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(1)),
				new TreeNode(9, new TreeNode(3), new TreeNode(7)));
		assert kthLargestLevelSum(rootOne, 2) == 13;

		final TreeNode rootTwo = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
		assert kthLargestLevelSum(rootTwo, 1) == 3;
	}

	static long kthLargestLevelSum(TreeNode root, int k) {
		final List<Long> levelSum = new ArrayList<>();
		visitTree(root, 0, levelSum);
		final int n = levelSum.size();
		if (k > n)
			return -1;
		else
			return GenericQuickSelect.randomizedSelect(levelSum.toArray(new Long[0]), 0, n - 1, n - k + 1,
					Long::compare);
	}

	private static void visitTree(TreeNode node, int level, List<Long> levelSum) {
		if (node == null)
			return;
		if (levelSum.size() > level)
			levelSum.set(level, levelSum.get(level) + node.val);
		else
			levelSum.add((long) node.val);
		visitTree(node.left, level + 1, levelSum);
		visitTree(node.right, level + 1, levelSum);
	}
}
