package com.coding.challenge.tree;

import org.junit.Assert;

import com.coding.challenge.bst.TreeNode;

class TreeDiameter {
	TreeDiameter() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// usecase one.
		final TreeNode r1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		int d = diameterOfBinaryTree(r1);
		Assert.assertEquals(3, d);

		// usecase two.
		final TreeNode r2 = new TreeNode(1, new TreeNode(2), null);
		d = diameterOfBinaryTree(r2);
		Assert.assertEquals(1, d);

		// usecase three.
		d = diameterOfBinaryTree(new TreeNode(1));
		Assert.assertEquals(0, d);

		// usecase four.
		final TreeNode r3 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, new TreeNode(5), new TreeNode(6)),
				new TreeNode(4, null, new TreeNode(7))));
		d = diameterOfBinaryTree(r3);
		Assert.assertEquals(4, d);
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
