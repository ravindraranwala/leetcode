package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class SumOfNodesWithEvenValuedGrandparent {
	SumOfNodesWithEvenValuedGrandparent() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root = new TreeNode(6,
				new TreeNode(7, new TreeNode(2, new TreeNode(9), null),
						new TreeNode(7, new TreeNode(1), new TreeNode(4))),
				new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
		assert sumEvenGrandparent(root) == 18;

		assert sumEvenGrandparent(new TreeNode(1)) == 0;
	}

	static int sumEvenGrandparent(TreeNode root) {
		return visitTree(root, null, null);
	}

	private static int visitTree(TreeNode node, TreeNode parent, TreeNode grandParent) {
		if (node == null)
			return 0;
		final int leftSum = visitTree(node.left, node, parent);
		final int rightSum = visitTree(node.right, node, parent);
		int sum = leftSum + rightSum;
		if (grandParent != null && grandParent.val % 2 == 0)
			sum = sum + node.val;
		return sum;
	}
}
