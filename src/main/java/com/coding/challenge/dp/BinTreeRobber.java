package com.coding.challenge.dp;

import com.coding.challenge.bst.TreeNode;

class BinTreeRobber {

	BinTreeRobber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)),
				new TreeNode(3, null, new TreeNode(1)));
		int p = rob(r1);
		System.out.println(p);

		final TreeNode r2 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)),
				new TreeNode(5, null, new TreeNode(1)));
		p = rob(r2);
		System.out.println(p);

		final TreeNode r3 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3));
		p = rob(r3);
		System.out.println(p);
		
		p = rob(new TreeNode(4));
		System.out.println(p);
	}

	static int rob(TreeNode root) {
		final int[] p = robRec(root);
		return p[1];
	}

	static int[] robRec(TreeNode root) {
		if (root == null)
			return new int[] { 0, 0 };
		final int[] a1 = robRec(root.left);
		final int[] a2 = robRec(root.right);
		final int p1 = a1[0] + a2[0];
		final int p2 = a1[1] + a2[1];
		final int tmp = Math.max(p1 + root.val, p2);
		return new int[] { p2, tmp };
	}
}
