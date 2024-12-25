package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class FindLargestValueInEachTreeRow {
	FindLargestValueInEachTreeRow() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)),
				new TreeNode(2, null, new TreeNode(9)));
		assert Arrays.asList(1, 3, 9).equals(largestValues(root1));
	}

	static List<Integer> largestValues(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		dfs(root, l, 0);
		return l;
	}

	private static void dfs(TreeNode root, List<Integer> l, int h) {
		if (root == null)
			return;

		if (l.size() == h)
			l.add(root.val);
		else
			l.set(h, Math.max(l.get(h), root.val));

		dfs(root.left, l, h + 1);
		dfs(root.right, l, h + 1);
	}
}
