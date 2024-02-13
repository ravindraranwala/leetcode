package com.coding.challenge.dfs;

import java.util.HashSet;
import java.util.Set;

import com.coding.challenge.bst.TreeNode;

class FindElements {
	final Set<Integer> recoveredVals = new HashSet<>();

	public FindElements(TreeNode root) {
		root.val = 0;
		recoveredVals.add(root.val);
		recoverTree(root);
	}

	public static void main(String[] args) {
		final FindElements findElmt1 = new FindElements(new TreeNode(-1, null, new TreeNode(-1)));
		assert !findElmt1.find(1);
		assert findElmt1.find(2);

		final FindElements findElmt2 = new FindElements(
				new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), new TreeNode(-1)), new TreeNode(-1)));
		assert findElmt2.find(1);
		assert findElmt2.find(3);
		assert !findElmt2.find(5);
	}

	public boolean find(int target) {
		return recoveredVals.contains(target);
	}

	private void recoverTree(TreeNode root) {
		if (root.left != null) {
			root.left.val = root.val * 2 + 1;
			recoveredVals.add(root.left.val);
			recoverTree(root.left);
		}
		if (root.right != null) {
			root.right.val = root.val * 2 + 2;
			recoveredVals.add(root.right.val);
			recoverTree(root.right);
		}
	}
}
