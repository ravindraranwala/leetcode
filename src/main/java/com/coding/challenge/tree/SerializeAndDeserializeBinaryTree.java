package com.coding.challenge.tree;

import java.util.StringJoiner;

import com.coding.challenge.bst.TreeNode;

class SerializeAndDeserializeBinaryTree {
	private static final String NIL = "#";
	private static final char COMMA = ',';

	SerializeAndDeserializeBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
		assert "[2, 1, 4, 3, 5]".equals(deserialize(serialize(rootOne)).toString());
		
		assert deserialize(serialize(null)) == null;
	}

	static String serialize(TreeNode root) {
		final StringJoiner sj = new StringJoiner(COMMA + "");
		encode(root, sj);
		return sj.toString();
	}

	private static void encode(TreeNode node, StringJoiner tree) {
		if (node == null)
			tree.add(NIL);
		else {
			// pre-order serialization of a binary tree.
			tree.add(String.valueOf(node.val));
			encode(node.left, tree);
			encode(node.right, tree);
		}
	}

	static TreeNode deserialize(String data) {
		return decode(data, new int[] { -1 }, data.length());
	}

	private static TreeNode decode(String tree, int[] a, int n) {
		a[0] = a[0] + 1;
		final int i = a[0];
		while (a[0] < n && tree.charAt(a[0]) != COMMA)
			a[0] = a[0] + 1;

		final String key = tree.substring(i, a[0]);
		if (NIL.equals(key))
			return null;

		final TreeNode left = decode(tree, a, n);
		final TreeNode right = decode(tree, a, n);
		return new TreeNode(Integer.valueOf(key), left, right);
	}
}
