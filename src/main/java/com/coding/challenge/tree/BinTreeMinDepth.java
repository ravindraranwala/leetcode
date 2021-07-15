package com.coding.challenge.tree;

import java.util.ArrayDeque;
import java.util.Queue;

import com.coding.challenge.bst.TreeNode;

class BinTreeMinDepth {

	BinTreeMinDepth() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode three = new TreeNode(3);
		final TreeNode nine = new TreeNode(9);
		three.left = nine;
		final TreeNode twenty = new TreeNode(20);
		three.right = twenty;
		final TreeNode fifteen = new TreeNode(15);
		final TreeNode seven = new TreeNode(7);
		twenty.left = fifteen;
		twenty.right = seven;

		int d = minDepth(three);
		System.out.println(String.format("Min depth of the binary tree: %d", d));

		// Usecase 2
		final TreeNode two = new TreeNode(2);
		final TreeNode three2 = new TreeNode(3);
		two.right = three2;
		final TreeNode four = new TreeNode(4);
		three2.right = four;
		final TreeNode five = new TreeNode(5);
		four.right = five;
		final TreeNode six = new TreeNode(6);
		five.right = six;

		d = minDepth(two);
		System.out.println(String.format("Min depth of the binary tree: %d", d));
	}

	static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int d = 1;
		final Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		while (!q.isEmpty()) {
			final int size = q.size();
			for (int i = 0; i < size; i++) {
				final TreeNode n = q.poll();
				// leaf node found
				if (n.left == null && n.right == null)
					return d;
				if (n.left != null)
					q.offer(n.left);
				if (n.right != null)
					q.offer(n.right);
			}
			// current level is complete
			d++;
		}
		return d;
	}
}
