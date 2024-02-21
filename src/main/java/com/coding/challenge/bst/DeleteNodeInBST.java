package com.coding.challenge.bst;

class DeleteNodeInBST {
	DeleteNodeInBST() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7)));
		assert "[2, 4, 5, 6, 7]".equals(deleteNode(root1, 3).toString());

		assert deleteNode(new TreeNode(0), 0) == null;

		final TreeNode root2 = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
				new TreeNode(6, null, new TreeNode(7)));
		assert "[2, 3, 4, 5, 6]".equals(deleteNode(root2, 7).toString());
	}

	static TreeNode deleteNode(TreeNode root, int key) {
		final TreeNode[] toDelete = new TreeNode[2];
		findNode(root, key, null, toDelete);
		// node not found.
		if (toDelete[1] == null)
			return root;
		final TreeNode z = toDelete[1];
		final TreeNode zsParent = toDelete[0];
		final TreeNode[] newRoot = new TreeNode[] { root };
		if (z.left == null)
			transplant(z, z.right, zsParent, newRoot);
		else if (z.right == null)
			transplant(z, z.left, zsParent, newRoot);
		else {
			final TreeNode[] successor = treeMinimum(z.right, z);
			final TreeNode ysParent = successor[0];
			final TreeNode y = successor[1];
			if (y != z.right) {
				transplant(y, y.right, ysParent, newRoot);
				y.right = z.right;
			}
			transplant(z, y, zsParent, newRoot);
			y.left = z.left;
		}
		return newRoot[0];
	}

	static void transplant(TreeNode u, TreeNode v, TreeNode p, TreeNode[] newRoot) {
		if (p == null)
			newRoot[0] = v;
		else if (u == p.left)
			p.left = v;
		else
			p.right = v;
	}

	private static void findNode(TreeNode node, int key, TreeNode parent, TreeNode[] ans) {
		if (node == null)
			return;
		if (node.val == key) {
			ans[0] = parent;
			ans[1] = node;
			return;
		}
		findNode(node.left, key, node, ans);
		findNode(node.right, key, node, ans);
	}

	private static TreeNode[] treeMinimum(TreeNode node, TreeNode parent) {
		TreeNode x = node;
		TreeNode p = parent;
		while (x.left != null) {
			p = x;
			x = x.left;
		}
		return new TreeNode[] { p, x };
	}
}
