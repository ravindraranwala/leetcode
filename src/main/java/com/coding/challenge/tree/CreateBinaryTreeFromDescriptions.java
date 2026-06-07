package com.coding.challenge.tree;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.bst.TreeNode;

class CreateBinaryTreeFromDescriptions {
	CreateBinaryTreeFromDescriptions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] descriptions1 = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
		assert "[15, 20, 17, 50, 19, 80]".equals(createBinaryTree(descriptions1).toString());

		final int[][] descriptions2 = { { 1, 2, 1 }, { 2, 3, 0 }, { 3, 4, 1 } };
		assert "[2, 4, 3, 1]".equals(createBinaryTree(descriptions2).toString());
	}

	static TreeNode createBinaryTree(int[][] descriptions) {
		final Map<Integer, TreeNode> t = new HashMap<>();
		for (int[] e : descriptions) {
			TreeNode p = null;
			if (t.containsKey(e[0]))
				p = t.get(e[0]);
			else {
				p = new TreeNode(e[0]);
				t.put(e[0], p);
			}

			TreeNode c = null;
			if (t.containsKey(e[1]))
				c = t.get(e[1]);
			else {
				c = new TreeNode(e[1]);
				t.put(e[1], c);
			}

			// create the link here.
			if (e[2] == 1)
				p.left = c;
			else
				p.right = c;
		}

		for (int[] e : descriptions)
			t.remove(e[1]);

		return t.values().iterator().next();
	}
}
