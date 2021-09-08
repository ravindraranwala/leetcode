package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class FlattenToLinkedList {
	FlattenToLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		final TreeNode five = new TreeNode(5, null, new TreeNode(6));
		one.left = two;
		one.right = five;
		flatten(one);
		System.out.println(one);

		// Usecase 2.
		final TreeNode root = null;
		flatten(root);
		System.out.println(root);

		// Usecase 3.
		final TreeNode zero = new TreeNode(0);
		flatten(zero);
		System.out.println(zero);
	}

	static void flatten(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TreeNode pre = curr.left;
				while (pre.right != null)
					pre = pre.right;

				pre.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
	}
}
