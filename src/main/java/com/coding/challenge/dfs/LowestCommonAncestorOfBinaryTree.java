package com.coding.challenge.dfs;

import com.coding.challenge.bst.TreeNode;

class LowestCommonAncestorOfBinaryTree {
	private TreeNode lca = null;

	LowestCommonAncestorOfBinaryTree() {

	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3,
				new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
				new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		assert new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root1, new TreeNode(5),
				new TreeNode(1)).val == 3;

		assert new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root1, new TreeNode(5),
				new TreeNode(4)).val == 5;

		final TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
		assert new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor(root2, new TreeNode(1),
				new TreeNode(2)).val == 1;
	}

	TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root, p.val, q.val);
		return lca;
	}

	int dfs(TreeNode root, int pVal, int qVal) {
		if (root == null)
			return 0;
		int cnt = 0;
		if (root.val == pVal || root.val == qVal)
			cnt = cnt + 1;
		cnt = cnt + dfs(root.left, pVal, qVal);
		cnt = cnt + dfs(root.right, pVal, qVal);
		if (lca == null && cnt == 2)
			lca = root;
		return cnt;
	}
}
