package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class BinTreeMinDepth {

	BinTreeMinDepth() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode three = new TreeNode(3);
		final TreeNode nine = new TreeNode(9);
		three.left = nine;
		final TreeNode twenty = new TreeNode(20);
		three.right = twenty;
		final TreeNode fifteen = new TreeNode(15);
		final TreeNode seven = new TreeNode(7);
		twenty.left = fifteen;
		twenty.right = seven;

		int d = minDepth(three);
		System.out.println(String.format("Min depth of the binary tree: %d", d));

		// Usecase 2
		final TreeNode two = new TreeNode(2);
		final TreeNode three2 = new TreeNode(3);
		two.right = three2;
		final TreeNode four = new TreeNode(4);
		three2.right = four;
		final TreeNode five = new TreeNode(5);
		four.right = five;
		final TreeNode six = new TreeNode(6);
		five.right = six;

		d = minDepth(two);
		System.out.println(String.format("Min depth of the binary tree: %d", d));

		// Usecase 1 max depth.
		d = maxDepth(three);
		System.out.println(String.format("Min depth of the binary tree: %d", d));

		// Usecase 2 max depth.
		final TreeNode one = new TreeNode(1);
		final TreeNode two2 = new TreeNode(2);
		one.right = two2;
		d = maxDepth(one);
		System.out.println(String.format("Min depth of the binary tree: %d", d));

		// Usecase 3 max depth.
		d = maxDepth(null);
		System.out.println(String.format("Min depth of the binary tree: %d", d));

		// Usecase 4 max depth.
		final TreeNode zero = new TreeNode(0);
		d = maxDepth(zero);
		System.out.println(String.format("Min depth of the binary tree: %d", d));
	}

	/**
	 * Uses a variant of Depth-First-Search to find the minimum depth of a Binary
	 * tree. The minimum depth is the number of nodes along the shortest path from
	 * the root node down to the nearest leaf node.Note: A leaf is a node with no
	 * children.
	 * 
	 * @param root
	 * @return
	 */
	static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		// leaf node found
		if (root.left == null && root.right == null)
			return 1;
		// non-leaf node can have one or two children
		int l = Integer.MAX_VALUE;
		int r = Integer.MAX_VALUE;
		if (root.left != null)
			l = minDepth(root.left);
		if (root.right != null)
			r = minDepth(root.right);
		return Math.min(l, r) + 1;
	}

	static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int l = 0;
		int r = 0;
		l = maxDepth(root.left);
		r = maxDepth(root.right);
		return Math.max(l, r) + 1;
	}
}
