package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class AddOneRowToTree {
	AddOneRowToTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)),
				new TreeNode(6, new TreeNode(5), null));
		assert "[3, 2, 1, 1, 4, 1, 5, 6]".equals(addOneRow(r1, 1, 2).toString());

		final TreeNode r2 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), null);
		assert "[3, 1, 2, 1, 1, 4]".equals(addOneRow(r2, 1, 3).toString());
	}

	static TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1)
			return new TreeNode(val, root, null);
		visitTree(root, val, depth, 1);
		return root;
	}

	private static void visitTree(TreeNode node, int val, int depth, int currDepth) {
		if (node == null)
			return;
		if (currDepth == depth - 1) {
			node.left = new TreeNode(val, node.left, null);
			node.right = new TreeNode(val, null, node.right);
		} else {
			visitTree(node.left, val, depth, currDepth + 1);
			visitTree(node.right, val, depth, currDepth + 1);
		}
	}
}
