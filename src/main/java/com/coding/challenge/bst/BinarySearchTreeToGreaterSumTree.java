package com.coding.challenge.bst;

class BinarySearchTreeToGreaterSumTree {
	private int greaterSum = 0;

	BinarySearchTreeToGreaterSumTree() {

	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
				new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
		new BinarySearchTreeToGreaterSumTree().bstToGst(root1);
		System.out.println(root1);
	}

	TreeNode bstToGst(TreeNode root) {
		dfs(root);
		return root;
	}

	private void dfs(TreeNode root) {
		if (root == null)
			return;
		dfs(root.right);
		greaterSum = greaterSum + root.val;
		root.val = greaterSum;
		dfs(root.left);
	}
}
