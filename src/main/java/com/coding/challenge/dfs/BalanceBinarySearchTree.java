package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class BalanceBinarySearchTree {
	BalanceBinarySearchTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
		System.out.println(balanceBST(root1));

		final TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		System.out.println(balanceBST(root2));
	}

	static TreeNode balanceBST(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		dfs(root, l);
		return buildBalancedTree(l, 0, l.size() - 1);
	}

	private static void dfs(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		dfs(root.left, l);
		l.add(root.val);
		dfs(root.right, l);
	}

	private static TreeNode buildBalancedTree(List<Integer> l, int i, int j) {
		if (i > j)
			return null;

		final int mid = (i + j) / 2;
		return new TreeNode(l.get(mid), buildBalancedTree(l, i, mid - 1), buildBalancedTree(l, mid + 1, j));
	}
}
