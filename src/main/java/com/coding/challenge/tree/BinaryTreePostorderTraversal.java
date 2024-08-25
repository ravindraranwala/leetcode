package com.coding.challenge.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class BinaryTreePostorderTraversal {
	BinaryTreePostorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		final List<Integer> l1 = Arrays.asList(3, 2, 1);
		assert l1.equals(postorderTraversal(root1));
	}

	static List<Integer> postorderTraversal(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		postOrderTreeWalk(root, l);
		return l;
	}

	private static void postOrderTreeWalk(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		postOrderTreeWalk(root.left, l);
		postOrderTreeWalk(root.right, l);
		l.add(root.val);
	}
}
