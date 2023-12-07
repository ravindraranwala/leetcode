package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class FindBottomLeftTreeValue {
	FindBottomLeftTreeValue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		assert findBottomLeftValue(r1) == 1;

		final TreeNode r2 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
				new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
		assert findBottomLeftValue(r2) == 7;

		final TreeNode r3 = new TreeNode(1, null, new TreeNode(4));
		assert findBottomLeftValue(r3) == 4;
	}

	static int findBottomLeftValue(TreeNode root) {
		return bottomLeftValue(root, null, 0)[1];
	}

	private static int[] bottomLeftValue(TreeNode curr, TreeNode p, int d) {
		if (curr == null)
			return new int[] { d - 1, p.val };
		final int[] l = bottomLeftValue(curr.left, curr, d + 1);
		final int[] r = bottomLeftValue(curr.right, curr, d + 1);
		if (l[0] >= r[0])
			return l;
		else
			return r;
	}
}
