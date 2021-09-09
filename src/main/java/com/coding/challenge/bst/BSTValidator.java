package com.coding.challenge.bst;

import java.util.ArrayDeque;
import java.util.Deque;

class BSTValidator {
	private static double pre = Double.NEGATIVE_INFINITY;

	BSTValidator() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode two = new TreeNode(2);
		two.left = new TreeNode(1);
		two.right = new TreeNode(3);
		boolean v = isValidBST2(two);
		System.out.println(v);

		final TreeNode five = new TreeNode(5);
		five.left = new TreeNode(1);
		final TreeNode four = new TreeNode(4);
		four.left = new TreeNode(3);
		four.right = new TreeNode(6);
		five.right = four;
		v = isValidBST2(five);
		System.out.println(v);

		// Usecase 3.
		final TreeNode five2 = new TreeNode(5);
		five2.left = new TreeNode(4);
		final TreeNode six = new TreeNode(6);
		six.left = new TreeNode(3);
		six.right = new TreeNode(7);
		five2.right = six;
		v = isValidBST2(five2);
		System.out.println(v);

		v = isValidBST2(new TreeNode(0));
		System.out.println(v);

		v = isValidBST2(new TreeNode(1, new TreeNode(1), null));
		System.out.println(v);
	}

	static boolean isValidBST(TreeNode root) {
		double pre = Double.NEGATIVE_INFINITY;
		final Deque<TreeNode> s = new ArrayDeque<>();
		TreeNode curr = root;
		while (!s.isEmpty() || curr != null) {
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				curr = s.pop();
				if (curr.val <= pre)
					return false;
				pre = curr.val;
				curr = curr.right;
			}
		}
		return true;
	}

	static boolean isValidBST2(TreeNode root) {
		pre = Double.NEGATIVE_INFINITY;
		return isValidBSTRec(root);
	}

	static boolean isValidBSTRec(TreeNode root) {
		if (root == null)
			return true;
		final boolean l = isValidBSTRec(root.left);
		if (!l)
			return l;
		if (root.val <= pre)
			return false;
		pre = root.val;
		return isValidBSTRec(root.right);
	}
}
