package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class PathSum {

	PathSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// usecase 1.
		final TreeNode eleven = new TreeNode(11);
		final TreeNode seven = new TreeNode(7);
		final TreeNode two = new TreeNode(2);
		eleven.left = seven;
		eleven.right = two;
		final TreeNode four = new TreeNode(4);
		four.left = eleven;

		final TreeNode four2 = new TreeNode(4);
		four2.right = new TreeNode(1);
		final TreeNode eight = new TreeNode(8);
		eight.left = new TreeNode(13);
		eight.right = four2;

		final TreeNode five = new TreeNode(5);
		five.left = four;
		five.right = eight;

		boolean found = hasPathSum(five, 22);
		System.out.println(String.format("Path sum found: %b", found));

		// usecase 2.
		final TreeNode one = new TreeNode(1);
		one.left = new TreeNode(2);
		one.right = new TreeNode(3);

		found = hasPathSum(five, 5);
		System.out.println(String.format("Path sum found: %b", found));

		// usecase 3.
		one.right = null;
		found = hasPathSum(five, 0);
		System.out.println(String.format("Path sum found: %b", found));

		// usecase 4.
		found = hasPathSum(null, 4);
		System.out.println(String.format("Path sum found: %b", found));
	}

	/**
	 * Given the root of a binary tree and an integer targetSum, return true if the
	 * tree has a root-to-leaf path such that adding up all the values along the the
	 * path equals targetSum.
	 * 
	 * A leaf is a node with no children.
	 * 
	 * @param root      the root of a binary tree
	 * @param targetSum expected sum
	 * @return <code>true</code> if the tree has a root-to-leaf path such that
	 *         adding up all the values along the path equals targetSum.
	 *         <code>false</code> otherwise.
	 */
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		// leaf node found !
		if (root.left == null && root.right == null)
			return root.val == targetSum;
		final boolean l = hasPathSum(root.left, targetSum - root.val);
		final boolean r = hasPathSum(root.right, targetSum - root.val);
		return l || r;
	}
}
