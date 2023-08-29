package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class RecoverTreeFromPreorderTraversal {
	RecoverTreeFromPreorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "[3, 2, 4, 1, 6, 5, 7]".equals(recoverFromPreorder("1-2--3--4-5--6--7").toString());
		assert "[4, 3, 2, 1, 7, 6, 5]".equals(recoverFromPreorder("1-2--3---4-5--6---7").toString());
		assert "[90, 349, 401, 88, 1]".equals(recoverFromPreorder("1-401--349---90--88").toString());
		assert "[3]".equals(recoverFromPreorder("3").toString());
	}

	static TreeNode recoverFromPreorder(String traversal) {
		final TreeNode dummy = new TreeNode(-1);
		visitTree(dummy, traversal, 0, -1);
		return dummy.left;
	}

	private static int[] visitTree(TreeNode node, String traversal, int i, int d) {
		final int n = traversal.length();
		if (i == n)
			return new int[] { -1, -1, -1 };

		int j = i;
		while (traversal.charAt(j) == '-')
			j = j + 1;

		int k = j;
		final StringBuilder sb = new StringBuilder();
		while (k < n && traversal.charAt(k) != '-') {
			sb.append(traversal.charAt(k));
			k = k + 1;
		}
		final int key = Integer.parseInt(sb.toString());
		if ((j - i) > d) {
			final TreeNode left = new TreeNode(key);
			node.left = left;
			final int[] right = visitTree(left, traversal, k, d + 1);
			if (right[0] == d + 1) {
				node.right = new TreeNode(right[2]);
				return visitTree(node.right, traversal, right[1], right[0]);
			}
			return right;
		} else
			return new int[] { (j - i), k, key };
	}
}
