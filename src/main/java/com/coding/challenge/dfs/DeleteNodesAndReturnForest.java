package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.coding.challenge.bst.TreeNode;

class DeleteNodesAndReturnForest {
	DeleteNodesAndReturnForest() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), new TreeNode(7)));
		final int[] toDelete1 = { 3, 5 };
		System.out.println(delNodes(root1, toDelete1));
	}

	static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		final Set<Integer> toDelete = new HashSet<>();
		for (int node : to_delete)
			toDelete.add(node);
		final List<TreeNode> l = new ArrayList<>();
		if (!deleteNode(root, toDelete, l))
			l.add(root);
		return l;
	}

	private static boolean deleteNode(TreeNode root, Set<Integer> toDelete, List<TreeNode> l) {
		if (root == null)
			return false;
		if (deleteNode(root.left, toDelete, l))
			root.left = null;

		if (deleteNode(root.right, toDelete, l))
			root.right = null;

		final boolean deleteCurr = toDelete.contains(root.val);
		if (deleteCurr) {
			if (root.left != null)
				l.add(root.left);
			if (root.right != null)
				l.add(root.right);
		}
		return deleteCurr;
	}
}
