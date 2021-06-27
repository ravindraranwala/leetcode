package com.coding.challenge.bst;

import com.coding.challenge.bst.BSTIterator.TreeNode;

class LowestCommonAncestor {

	private LowestCommonAncestor() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Test case 1.
		final TreeNode root = new TreeNode(6);
		final TreeNode two = new TreeNode(2);
		root.left = two;
		final TreeNode zero = new TreeNode(0);
		two.left = zero;
		final TreeNode four = new TreeNode(4);
		final TreeNode three = new TreeNode(3);
		final TreeNode five = new TreeNode(5);
		four.left = three;
		four.right = five;

		final TreeNode eight = new TreeNode(8);
		final TreeNode seven = new TreeNode(7);
		final TreeNode nine = new TreeNode(9);
		eight.left = seven;
		eight.right = nine;
		root.right = eight;

		final TreeNode p = new TreeNode(2);
		final TreeNode q = new TreeNode(8);
		final TreeNode lca = lowestCommonAncestor(root, p, q);
		System.out.println(lca.val);

		final TreeNode r = new TreeNode(4);
		final TreeNode lca2 = lowestCommonAncestor(root, p, r);
		System.out.println(lca2.val);
	}

	static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		else if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		else
			return root; // base case of the recursion.
	}
}
