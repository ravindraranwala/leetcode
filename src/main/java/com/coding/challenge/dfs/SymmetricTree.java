package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class SymmetricTree {
	SymmetricTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		assert isSymmetric(root1);

		final TreeNode root2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)),
				new TreeNode(2, null, new TreeNode(3)));
		assert !isSymmetric(root2);

		final TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(2), null),
				new TreeNode(2, new TreeNode(2), null));
		assert !isSymmetric(root3);

		assert !isSymmetric(new TreeNode(1, new TreeNode(0), null));

		assert !isSymmetric(new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null));
	}

	static boolean isSymmetric(TreeNode root) {
		final List<List<Integer>> levels = new ArrayList<>();
		inorder(root, levels, 0);
		for (List<Integer> list : levels) {
			final int n = list.size();
			final int mid = n / 2;
			for (int i = 0; i < mid; i++)
				if (!list.get(i).equals(list.get(n - i - 1)))
					return false;
		}
		return true;
	}

	private static void inorder(TreeNode node, List<List<Integer>> ans, int l) {
		if (ans.size() == l)
			ans.add(new ArrayList<>());
		if (node == null) {
			ans.get(l).add(-1000);
			return;
		}
		inorder(node.left, ans, l + 1);
		ans.get(l).add(node.val);
		inorder(node.right, ans, l + 1);
	}
}
