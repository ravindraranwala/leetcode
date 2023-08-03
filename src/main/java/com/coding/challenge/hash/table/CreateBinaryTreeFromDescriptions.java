package com.coding.challenge.hash.table;

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
		final Map<Integer, TreeNode> t = new HashMap<>();

		for (int[] d : descriptions) {
			t.merge(d[1], new TreeNode(d[1]), (a, b) -> a);
			t.merge(d[0], new TreeNode(d[0]), (a, b) -> a);
			if (d[2] == 1)
				t.get(d[0]).left = t.get(d[1]);
			else
				t.get(d[0]).right = t.get(d[1]);
		}

		// find the root node.
		for (int[] d : descriptions)
			t.remove(d[1]);

		return t.entrySet().iterator().next().getValue();
	}
}
