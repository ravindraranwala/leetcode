package com.coding.challenge.bst;

import java.util.ArrayDeque;
import java.util.Deque;

class BSTValidator {

	BSTValidator() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode two = new TreeNode(2);
		two.left = new TreeNode(1);
		two.right = new TreeNode(3);
		boolean v = isValidBST(two);
		System.out.println(v);

		final TreeNode five = new TreeNode(5);
		five.left = new TreeNode(1);
		final TreeNode four = new TreeNode(4);
		four.left = new TreeNode(3);
		four.right = new TreeNode(6);
		five.right = four;
		v = isValidBST(five);
		System.out.println(v);

		// Usecase 3.
		final TreeNode five2 = new TreeNode(5);
		five2.left = new TreeNode(4);
		final TreeNode six = new TreeNode(6);
		six.left = new TreeNode(3);
		six.right = new TreeNode(7);
		five2.right = six;
		v = isValidBST(five2);
		System.out.println(v);
	}

	static boolean isValidBST(TreeNode node) {
		final Deque<TreeNode> s = new ArrayDeque<>();
		TreeNode prev = null;
		while (node != null || !s.isEmpty()) {
			if (node != null) {
				s.push(node);
				node = node.left;
			} else {
				final TreeNode n = s.pop();
				if (prev != null && prev.val >= n.val)
					return false;
				prev = n;
				node = n.right;
			}
		}
		return true;
	}
}
