package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

import com.coding.challenge.bst.TreeNode;

class DeepestLeavesSum {
	DeepestLeavesSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(1,
				new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)),
				new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
		assert deepestLeavesSum(rootOne) == 15;
	}

	static int deepestLeavesSum(TreeNode root) {
		final Deque<TreeNode> q1 = new ArrayDeque<>();
		final Deque<Integer> q2 = new ArrayDeque<>();
		final Deque<int[]> s = new ArrayDeque<>();
		q1.offer(root);
		q2.offer(0);
		while (!q1.isEmpty()) {
			final TreeNode node = q1.poll();
			final int d = q2.poll();
			s.push(new int[] { node.val, d });
			if (node.left != null) {
				q1.offer(node.left);
				q2.offer(d + 1);
			}
			if (node.right != null) {
				q1.offer(node.right);
				q2.offer(d + 1);
			}
		}

		final int l = s.peek()[1];
		int sum = 0;
		while (!s.isEmpty() && s.peek()[1] == l)
			sum = sum + s.pop()[0];
		return sum;
	}
}
