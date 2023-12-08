package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class BinaryTreeRightSideView {
	BinaryTreeRightSideView() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode r1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)),
				new TreeNode(3, null, new TreeNode(4)));
		assert Arrays.asList(1, 3, 4).equals(rightSideView(r1));

		final TreeNode r2 = new TreeNode(1, null, new TreeNode(3));
		assert Arrays.asList(1, 3).equals(rightSideView(r2));

		assert Collections.emptyList().equals(rightSideView(null));
	}

	static List<Integer> rightSideView(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		visitTree(root, l, 0);
		return l;
	}

	private static void visitTree(TreeNode node, List<Integer> a, int l) {
		if (node == null)
			return;
		if (a.size() == l)
			a.add(node.val);
		else
			a.set(l, node.val);
		visitTree(node.left, a, l + 1);
		visitTree(node.right, a, l + 1);
	}
}
