package com.coding.challenge.bst;

class BSTInsert {
	BSTInsert() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
		assert "[1, 2, 3, 4, 5, 7]".equals(insertIntoBST(rootOne, 5).toString());

		final TreeNode rootTwo = new TreeNode(40, new TreeNode(20, new TreeNode(10), new TreeNode(30)),
				new TreeNode(60, new TreeNode(50), new TreeNode(70)));
		assert "[10, 20, 25, 30, 40, 50, 60, 70]".equals(insertIntoBST(rootTwo, 25).toString());

		final TreeNode rootThree = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
		assert "[1, 2, 3, 4, 5, 7]".equals(insertIntoBST(rootThree, 5).toString());
	}

	static TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode y = null;
		TreeNode x = root;
		while (x != null) {
			y = x;
			if (val < x.val)
				x = x.left;
			else
				x = x.right;
		}

		final TreeNode newNode = new TreeNode(val);
		if (y == null)
			return newNode;
		else if (val < y.val)
			y.left = newNode;
		else
			y.right = newNode;

		return root;
	}
}
