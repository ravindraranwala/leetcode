package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class CountNodesEqualToAverageOfSubtree {
	CountNodesEqualToAverageOfSubtree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(4, new TreeNode(8, new TreeNode(0), new TreeNode(1)),
				new TreeNode(5, null, new TreeNode(6)));
		assert averageOfSubtree(root1) == 5;

		assert averageOfSubtree(new TreeNode(1)) == 1;
	}

	static int averageOfSubtree(TreeNode root) {
		final int[] ans = new int[1];
		traverse(root, ans);
		return ans[0];
	}

	private static int[] traverse(TreeNode root, int[] ans) {
		if (root == null)
			return new int[] { 0, 0 };

		final int[] left = traverse(root.left, ans);
		final int[] right = traverse(root.right, ans);
		final int sum = left[0] + right[0] + root.val;
		final int cnt = left[1] + right[1] + 1;
		if (root.val == sum / cnt)
			ans[0] = ans[0] + 1;

		return new int[] { sum, cnt };
	}
}
