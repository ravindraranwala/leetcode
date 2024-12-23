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
		final Queue<Vertex> q = new ArrayDeque<>();
		q.offer(new Vertex(root, 0));
		final Deque<Integer> s = new ArrayDeque<>();
		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			if (u.node.left != null) {
				final Vertex l = new Vertex(u.node.left, u.d + 1);
				q.offer(l);
				final Vertex r = new Vertex(u.node.right, u.d + 1);
				q.offer(r);
				if (u.d % 2 == 0) {
					s.push(l.node.val);
					s.push(r.node.val);
				}
			}

			if (u.d % 2 == 1)
				u.node.val = s.pop();
		}
		return root;
	}
	
	private static class Vertex {
		private final TreeNode node;
		private final int d;

		private Vertex(TreeNode node, int d) {
			this.node = node;
			this.d = d;
		}
	}
}
