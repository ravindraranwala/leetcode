package com.coding.challenge.dc;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.bst.TreeNode;

class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	ConstructBinaryTreeFromInorderAndPostorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] postorderOne = { 9, 15, 7, 20, 3 };
		final int[] inorderOne = { 9, 3, 15, 20, 7 };
		assert "[9, 3, 15, 20, 7]".equals(buildTree(inorderOne, postorderOne).toString());

		final int[] postorderTwo = { -1 };
		final int[] inorderTwo = { -1 };
		assert "[-1]".equals(buildTree(inorderTwo, postorderTwo).toString());
	}

	static TreeNode buildTree(int[] inorder, int[] postorder) {
		final Map<Integer, Integer> inorderPositions = new HashMap<>();
		final int n = inorder.length;
		for (int i = 0; i < n; i++)
			inorderPositions.put(inorder[i], i);
		return constructTree(inorderPositions, postorder, 0, n - 1, n - 1);
	}

	private static TreeNode constructTree(Map<Integer, Integer> inorderPositions, int[] postorder, int start, int end,
			int i) {
		// empty sub-tree.
		if (end < start)
			return null;
		final int key = postorder[i];
		final int r = inorderPositions.get(key);
		// left sub tree
		final TreeNode right = constructTree(inorderPositions, postorder, r + 1, end, i - 1);
		// right sub tree.
		final TreeNode left = constructTree(inorderPositions, postorder, start, r - 1, i - (end - r + 1));
		return new TreeNode(key, left, right);
	}
}
