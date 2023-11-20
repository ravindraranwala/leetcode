package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coding.challenge.bst.TreeNode;

class ReverseBinaryTreeOddLevels {
	ReverseBinaryTreeOddLevels() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(2, new TreeNode(3, new TreeNode(8), new TreeNode(13)),
				new TreeNode(5, new TreeNode(21), new TreeNode(34)));
		assert "[8, 5, 13, 2, 21, 3, 34]".equals(reverseOddLevels(rootOne).toString());

		final TreeNode rootTwo = new TreeNode(7, new TreeNode(13), new TreeNode(11));
		assert "[11, 7, 13]".equals(reverseOddLevels(rootTwo).toString());
	}

	static TreeNode reverseOddLevels(TreeNode root) {
		final Map<Integer, List<TreeNode>> t = new HashMap<>();
		visitTree(root, 0, t);
		// reverse the node values at odd levels
		for (List<TreeNode> nodes : t.values()) {
			final int high = nodes.size() - 1;
			for (int low = 0; low <= high / 2; low++) {
				final TreeNode left = nodes.get(low);
				final TreeNode right = nodes.get(high - low);
				// swap
				final int tmp = left.val;
				left.val = right.val;
				right.val = tmp;
			}
		}
		return root;
	}

	private static void visitTree(TreeNode p, int l, Map<Integer, List<TreeNode>> t) {
		if (p == null)
			return;
		if (l % 2 == 1)
			t.computeIfAbsent(l, unused -> new ArrayList<>()).add(p);
		visitTree(p.left, l + 1, t);
		visitTree(p.right, l + 1, t);
	}
}
