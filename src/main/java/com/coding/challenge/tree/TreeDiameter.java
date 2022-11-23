package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class TreeDiameter {
	TreeDiameter() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// usecase one.
		final TreeNode r1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		assert diameterOfBinaryTree(r1) == 3;

		// usecase two.
		final TreeNode r2 = new TreeNode(1, new TreeNode(2), null);
		assert diameterOfBinaryTree(r2) == 1;

		// usecase three.
		assert diameterOfBinaryTree(new TreeNode(1)) == 0;

		// usecase four.
		final TreeNode r3 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, new TreeNode(5), new TreeNode(6)),
				new TreeNode(4, null, new TreeNode(7))));
		assert diameterOfBinaryTree(r3) == 4;
	}

	static int diameterOfBinaryTree(TreeNode root) {
		return visitTree(root)[1];
	}

	static int[] visitTree(TreeNode n) {
		if (n == null)
			return new int[] { -1, -1 };

		final int[] l = visitTree(n.left);
		final int[] r = visitTree(n.right);
		final int d = Math.max(l[0] + r[0] + 2, Math.max(l[1], r[1]));
		final int m = Math.max(l[0], r[0]) + 1;
		return new int[] { m, d };
	}
}
