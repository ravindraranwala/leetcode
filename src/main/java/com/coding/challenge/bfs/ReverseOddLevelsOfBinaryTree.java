package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import com.coding.challenge.bst.TreeNode;

class ReverseOddLevelsOfBinaryTree {
	ReverseOddLevelsOfBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(2, new TreeNode(3, new TreeNode(8), new TreeNode(13)),
				new TreeNode(5, new TreeNode(21), new TreeNode(34)));
		System.out.println(reverseOddLevels(root1));

		System.out.println(reverseOddLevels(new TreeNode(7, new TreeNode(13), new TreeNode(11))));
	}

	static TreeNode reverseOddLevels(TreeNode root) {
		final Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		final Deque<Integer> s = new ArrayDeque<>();
		int c = 0;
		while (!q.isEmpty()) {
			final TreeNode u = q.poll();
			c = c + 1;
			final int h = (int) (Math.log10(c) / Math.log10(2));
			if (u.left != null) {
				q.offer(u.left);
				q.offer(u.right);
				if (h % 2 == 0) {
					s.push(u.left.val);
					s.push(u.right.val);
				}
			}

			if (h % 2 == 1)
				u.val = s.pop();
		}
		return root;
	}
}
