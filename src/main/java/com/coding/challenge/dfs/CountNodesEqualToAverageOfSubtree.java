package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class CountNodesEqualToAverageOfSubtree {
	private int c = 0;

	CountNodesEqualToAverageOfSubtree() {
		
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(4, new TreeNode(8, new TreeNode(0), new TreeNode(1)),
				new TreeNode(5, null, new TreeNode(6)));
		assert new CountNodesEqualToAverageOfSubtree().averageOfSubtree(root1) == 5;

		assert new CountNodesEqualToAverageOfSubtree().averageOfSubtree(new TreeNode(1)) == 1;
	}

	int averageOfSubtree(TreeNode root) {
		postOrder(root);
		return c;
	}

	private int[] postOrder(TreeNode root) {
		if (root == null)
			return new int[2];
		final int[] l = postOrder(root.left);
		final int[] r = postOrder(root.right);
		final int sum = l[0] + r[0] + root.val;
		final int count = l[1] + r[1] + 1;
		if (sum / count == root.val)
			c = c + 1;
		return new int[] { sum, count };
	}
}
