package com.coding.challenge.dc;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.bst.TreeNode;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	ConstructBinaryTreeFromPreorderAndInorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] preorderOne = { 3, 9, 20, 15, 7 };
		final int[] inorderOne = { 9, 3, 15, 20, 7 };
		assert "[9, 3, 15, 20, 7]".equals(buildTree(preorderOne, inorderOne).toString());

		final int[] preorderTwo = { 3, 7, 8, 4, 10, 15, 5 };
		final int[] inorderTwo = { 8, 7, 4, 3, 15, 10, 5 };
		assert "[8, 7, 4, 3, 15, 10, 5]".equals(buildTree(preorderTwo, inorderTwo).toString());

		final int[] preorderThree = { 3, 7, 4, 10 };
		final int[] inorderThree = { 7, 4, 3, 10 };
		assert "[7, 4, 3, 10]".equals(buildTree(preorderThree, inorderThree).toString());

		final int[] preorderFour = { 3, 7, 4, 10, 8 };
		final int[] inorderFour = { 7, 4, 3, 8, 10 };
		assert "[7, 4, 3, 8, 10]".equals(buildTree(preorderFour, inorderFour).toString());

		final int[] preorderFive = { -1 };
		final int[] inorderFive = { -1 };
		assert "[-1]".equals(buildTree(preorderFive, inorderFive).toString());
	}

	static TreeNode buildTree(int[] preorder, int[] inorder) {
		final Map<Integer, Integer> inorderPositions = new HashMap<>();
		final int n = inorder.length;
		for (int i = 0; i < n; i++)
			inorderPositions.put(inorder[i], i);
		return constructTree(inorderPositions, preorder, 0, inorder.length - 1, 0);
	}

	private static TreeNode constructTree(Map<Integer, Integer> inorderPositions, int[] preorder, int start, int end,
			int i) {
		if (end < start)
			return null;
		final int key = preorder[i];
		final int r = inorderPositions.get(key);
		// left sub tree
		final TreeNode left = constructTree(inorderPositions, preorder, start, r - 1, i + 1);
		// right sub tree.
		final TreeNode right = constructTree(inorderPositions, preorder, r + 1, end, i + r - start + 1);
		return new TreeNode(key, left, right);
	}
}
