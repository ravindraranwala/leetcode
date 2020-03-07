package com.coding.challenge.bst;

public final class BSTIterator {
	private TreeNode next = null;
	private TreeNode parent = null;

	public static void main(String[] args) {
		// Setting up the BST first.
		final TreeNode rightSubtree = new TreeNode(15);
		rightSubtree.left = new TreeNode(9);
		rightSubtree.right = new TreeNode(20);

		final TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = rightSubtree;

		final BSTIterator bstIt = new BSTIterator(root);
		while (bstIt.hasNext())
			System.out.println(bstIt.next());

	}

	public BSTIterator(TreeNode root) {
		if (root != null)
			next = treeMinimum(root);
	}

	private TreeNode treeMinimum(TreeNode x) {
		while (x.left != null) {
			parent = x;
			x = x.left;
		}
		return x;
	}

	/** @return the next smallest number */
	public int next() {
		final int key = next.val;
		if (parent.left == next && next.right == null)
			next = parent;
		else
			next = next.right != null ? treeMinimum(next.right) : null;
		return key;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return next != null;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
