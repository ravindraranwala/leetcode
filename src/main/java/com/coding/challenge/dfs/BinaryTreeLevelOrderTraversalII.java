package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class BinaryTreeLevelOrderTraversalII {
	private final List<List<Integer>> ans = new ArrayList<>();

	BinaryTreeLevelOrderTraversalII() {

	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		final List<List<Integer>> ans = Arrays.asList(Arrays.asList(15, 7), Arrays.asList(9, 20), Arrays.asList(3));
		assert ans.equals(new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root1));
	}

	List<List<Integer>> levelOrderBottom(TreeNode root) {
		visitTree(root, 0);
		Collections.reverse(ans);
		return ans;
	}

	private void visitTree(TreeNode root, int l) {
		if (root == null)
			return;
		if (l == ans.size())
			ans.add(new ArrayList<>());
		ans.get(l).add(root.val);
		visitTree(root.left, l + 1);
		visitTree(root.right, l + 1);
	}
}
