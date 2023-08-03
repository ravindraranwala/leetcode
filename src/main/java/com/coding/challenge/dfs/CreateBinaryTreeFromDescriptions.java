package com.coding.challenge.dfs;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.bst.TreeNode;

class CreateBinaryTreeFromDescriptions {
	CreateBinaryTreeFromDescriptions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] descriptionOne = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
		System.out.println(createBinaryTree(descriptionOne));

		final int[][] descriptionTwo = { { 1, 2, 1 }, { 2, 3, 0 }, { 3, 4, 1 } };
		System.out.println(createBinaryTree(descriptionTwo));

		final int[][] descriptionThree = { { 20, 15, 1 } };
		System.out.println(createBinaryTree(descriptionThree));
	}

	static TreeNode createBinaryTree(int[][] descriptions) {
		final Map<Integer, Integer> parent = new HashMap<>();
		final Map<Integer, Integer> leftChild = new HashMap<>();
		final Map<Integer, Integer> rightChild = new HashMap<>();

		for (int[] d : descriptions) {
			parent.put(d[1], d[0]);
			if (d[2] == 1)
				leftChild.put(d[0], d[1]);
			else
				rightChild.put(d[0], d[1]);
		}

		// find the root node.
		int root = descriptions[0][0];
		while (parent.containsKey(root))
			root = parent.get(root);

		// System.out.println(root);
		return createBinTree(root, leftChild, rightChild);
	}

	private static TreeNode createBinTree(int k, Map<Integer, Integer> leftChild, Map<Integer, Integer> rightChild) {
		if (k == 0)
			return null;
		final TreeNode l = createBinTree(leftChild.getOrDefault(k, 0), leftChild, rightChild);
		final TreeNode r = createBinTree(rightChild.getOrDefault(k, 0), leftChild, rightChild);
		return new TreeNode(k, l, r);
	}
}
