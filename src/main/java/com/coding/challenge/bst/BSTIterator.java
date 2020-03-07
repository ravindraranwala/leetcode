package com.coding.challenge.bst;

import java.util.ArrayDeque;
import java.util.Deque;

public final class BSTIterator {
	private TreeNode next = null;
	private final Deque<TreeNode> nodesStack = new ArrayDeque<>();

	public static void main(String[] args) {
		// Setting up the BST first.
//		final TreeNode rightSubtree = new TreeNode(15);
//		rightSubtree.left = new TreeNode(9);
//		rightSubtree.right = new TreeNode(20);
//
//		final TreeNode root = new TreeNode(7);
//		root.left = new TreeNode(3);
//		root.right = rightSubtree;

		TreeNode root = new TreeNode(15);
		TreeNode three = new TreeNode(3);
		three.left = new TreeNode(2);
		three.right = new TreeNode(4);

		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode thirteen = new TreeNode(13);
		thirteen.left = new TreeNode(9);
		seven.right = thirteen;
		six.right = seven;
		six.left = three;

		TreeNode eighteen = new TreeNode(18);
		eighteen.left = new TreeNode(17);
		eighteen.right = new TreeNode(20);

		root.left = six;
		root.right = eighteen;

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
			nodesStack.addFirst(x);
			x = x.left;
		}

		nodesStack.addFirst(x);
		return x;
	}

	/** @return the next smallest number */
	public int next() {
		final int key = next.val;
		nodesStack.removeFirst();

		if (next.right != null)
			next = treeMinimum(next.right);
		else {
			TreeNode y = nodesStack.peek();
			while (y != null && y.right == next) {
				next = y;
				y = nodesStack.removeFirst();
			}
			next = y;
		}
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
