package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class BinaryTreeZigzagLevelOrderTraversal {
	BinaryTreeZigzagLevelOrderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		final List<List<Integer>> l1 = Arrays.asList(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7));
		assert l1.equals(zigzagLevelOrder(root1));

		final List<List<Integer>> l2 = Arrays.asList(Arrays.asList(1));
		assert l2.equals(zigzagLevelOrder(new TreeNode(1)));

		assert Collections.emptyList().equals(zigzagLevelOrder(null));
	}

	static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		final List<List<Integer>> l = new ArrayList<>();
		dfs(root, l, 0);
		final int n = l.size();
		for (int d = 1; d < n; d = d + 2)
			Collections.reverse(l.get(d));

		return l;
	}

	private static void dfs(TreeNode root, List<List<Integer>> l, int d) {
		if (root == null)
			return;
		if (l.size() == d)
			l.add(new ArrayList<>());

		l.get(d).add(root.val);
		dfs(root.left, l, d + 1);
		dfs(root.right, l, d + 1);
	}
}
