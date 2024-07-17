package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.bst.TreeNode;

class CreateBinaryTreeFromDescriptions {
	CreateBinaryTreeFromDescriptions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] descriptions = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };
		assert "[15, 20, 17, 50, 19, 80]".equals(createBinaryTree(descriptions).toString());

		final int[][] descriptions2 = { { 1, 2, 1 }, { 2, 3, 0 }, { 3, 4, 1 } };
		assert "[2, 4, 3, 1]".equals(createBinaryTree(descriptions2).toString());
	}

	static TreeNode createBinaryTree(int[][] descriptions) {
		final Map<Integer, TreeNode> t = new HashMap<>();
		for (int[] d : descriptions) {
			TreeNode p = null;
			if (t.containsKey(d[0]))
				p = t.get(d[0]);
			else {
				p = new TreeNode(d[0]);
				t.put(d[0], p);
			}

			TreeNode c = null;
			if (t.containsKey(d[1]))
				c = t.get(d[1]);
			else {
				c = new TreeNode(d[1]);
				t.put(d[1], c);
			}
			if (d[2] == 1)
				p.left = c;
			else
				p.right = c;

		}

		for (int[] d : descriptions)
			t.remove(d[1]);

		return t.values().iterator().next();
	}
}
