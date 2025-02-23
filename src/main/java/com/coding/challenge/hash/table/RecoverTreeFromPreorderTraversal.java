package com.coding.challenge.hash.table;

import com.coding.challenge.bst.TreeNode;

class RecoverTreeFromPreorderTraversal {
	private static final char ZERO = '0';
	private static final char DASH = '-';

	RecoverTreeFromPreorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(recoverFromPreorder("1-2--3--4-5--6--7"));
		System.out.println(recoverFromPreorder("1-2--3---4-5--6---7"));
		System.out.println(recoverFromPreorder("1-401--349---90--88"));
	}

	static TreeNode recoverFromPreorder(String traversal) {
		final int n = traversal.length();
		final TreeNode[] heightToNode = new TreeNode[n + 1];
		heightToNode[0] = new TreeNode(-1);

		int i = 0;
		while (i < n) {
			int h = 0;
			while (traversal.charAt(i) == DASH) {
				i = i + 1;
				h = h + 1;
			}

			int key = 0;
			while (i < n && traversal.charAt(i) != DASH) {
				key = key * 10 + traversal.charAt(i) - ZERO;
				i = i + 1;
			}

			final TreeNode p = heightToNode[h];
			final TreeNode node = new TreeNode(key);
			if (p.left == null)
				p.left = node;
			else
				p.right = node;

			heightToNode[h + 1] = node;
		}

		return heightToNode[1];
	}
}
