package com.coding.challenge.dfs;

import java.util.HashSet;
import java.util.Set;

import com.coding.challenge.bst.TreeNode;

class FindElements {
	final Set<Integer> s = new HashSet<>();

	public FindElements(TreeNode root) {
		root.val = 0;
		dfs(root);
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(-1, null, new TreeNode(-1));
		final FindElements findElements1 = new FindElements(root1);
		assert !findElements1.find(1);
		assert findElements1.find(2);

		final TreeNode root2 = new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), new TreeNode(-1)), new TreeNode(-1));
		final FindElements findElements2 = new FindElements(root2);
		assert findElements2.find(1);
		assert findElements2.find(3);
		assert !findElements2.find(5);

		final TreeNode root3 = new TreeNode(-1, null, new TreeNode(-1, new TreeNode(-1, new TreeNode(-1), null), null));
		final FindElements findElements3 = new FindElements(root3);
		assert findElements3.find(2);
		assert !findElements3.find(3);
		assert !findElements3.find(4);
		assert findElements3.find(5);
	}

	public boolean find(int target) {
		return s.contains(target);
	}
	
	private void dfs(TreeNode root) {
		s.add(root.val);
		if (root.left != null) {
			root.left.val = root.val * 2 + 1;
			dfs(root.left);
		}
		if (root.right != null) {
			root.right.val = root.val * 2 + 2;
			dfs(root.right);
		}
	}
}
