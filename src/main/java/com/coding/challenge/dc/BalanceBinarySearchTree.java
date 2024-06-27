package com.coding.challenge.dc;

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
	}

	static TreeNode balanceBST(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		inorderTreeWalk(root, l);
		return balanceTree(l, 0, l.size() - 1);
	}

	private static void inorderTreeWalk(TreeNode root, List<Integer> l) {
		if (root == null)
			return;

		inorderTreeWalk(root.left, l);
		l.add(root.val);
		inorderTreeWalk(root.right, l);
	}

	private static TreeNode balanceTree(List<Integer> l, int i, int j) {
		// An empty subtree.
		if (j < i)
			return null;
		final int m = (i + j) / 2;
		return new TreeNode(l.get(m), balanceTree(l, i, m - 1), balanceTree(l, m + 1, j));
	}
}
