package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class BinTreeLowestCommonAncestor {

	BinTreeLowestCommonAncestor() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode three = new TreeNode(3);
		final TreeNode five = new TreeNode(5);
		final TreeNode one = new TreeNode(1, new TreeNode(0), new TreeNode(8));
		three.left = five;
		three.right = one;
		five.left = new TreeNode(6);
		final TreeNode two = new TreeNode(2, new TreeNode(7), new TreeNode(4));
		five.right = two;
		TreeNode lca = lowestCommonAncestor(three, five, one);
		System.out.println(lca.val);
		
		// Usecase 2.
		lca = lowestCommonAncestor(three, five, new TreeNode(4));
		System.out.println(lca.val);
		
		// Usecase 3.
		final TreeNode one2 = new TreeNode(1);
		one2.right = new TreeNode(2);
		lca = lowestCommonAncestor(one2, one2, two);
		System.out.println(lca.val);
	}

	static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		final TreeNode l = lowestCommonAncestor(root.left, p, q);
		final TreeNode r = lowestCommonAncestor(root.right, p, q);
		if (root.val == p.val || root.val == q.val)
			return root;
		else if (l != null && r != null)
			return root;
		else if (l != null)
			return l;
		else
			return r;
	}
}
