package com.coding.challenge.bst;

import java.util.StringJoiner;

class SerializeAndDeserializeBST {
	private static final char COMMA = ',';

	SerializeAndDeserializeBST() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		assert "[1, 2, 3]".equals(deserialize(serialize(rootOne)).toString());

		assert deserialize(serialize(null)) == null;

		final TreeNode rootThree = new TreeNode(8,
				new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
				new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
		assert "[1, 3, 4, 6, 7, 8, 10, 13, 14]".equals(deserialize(serialize(rootThree)).toString());
	}

	static String serialize(TreeNode root) {
		final StringJoiner sj = new StringJoiner(COMMA + "");
		encode(root, sj);
		return sj.toString();
	}

	private static void encode(TreeNode node, StringJoiner tree) {
		if (node != null) {
			// pre-order serialization of a BST.
			tree.add(String.valueOf(node.val));
			encode(node.left, tree);
			encode(node.right, tree);
		}
	}

	static TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;
		return decode(data, new int[] { -1 }, data.length(), 10001);
	}

	private static TreeNode decode(String tree, int[] a, int n, int upperBoundKey) {
		if (a[0] == n)
			return null;
		int i = a[0] + 1;
		while (i < n && tree.charAt(i) != COMMA)
			i = i + 1;

		final int key = Integer.parseInt(tree.substring(a[0] + 1, i));
		if (key > upperBoundKey)
			return null;

		a[0] = i;
		final TreeNode left = decode(tree, a, n, key);
		final TreeNode right = decode(tree, a, n, upperBoundKey);
		return new TreeNode(key, left, right);
	}
}
