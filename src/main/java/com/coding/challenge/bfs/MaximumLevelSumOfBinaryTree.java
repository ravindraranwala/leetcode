package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class MaximumLevelSumOfBinaryTree {
	MaximumLevelSumOfBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
		assert maxLevelSumDfs(root1) == 2;

		final TreeNode root2 = new TreeNode(989, null,
				new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388, null, new TreeNode(-32127))));
		assert maxLevelSumDfs(root2) == 2;
	}

	static int maxLevelSum(TreeNode root) {
		// init.
		int l = 0;
		int s = Integer.MIN_VALUE;
		final Deque<TreeNode> q1 = new ArrayDeque<>();
		final Deque<Integer> q2 = new ArrayDeque<>();
		q1.offer(root);
		q2.offer(1);
		int currLevel = 0;
		int currSum = Integer.MIN_VALUE;
		while (!q1.isEmpty()) {
			final TreeNode u = q1.remove();
			final int level = q2.remove();
			if (level == currLevel)
				currSum = currSum + u.val;
			else {
				if (currSum > s) {
					l = currLevel;
					s = currSum;
				}

				currLevel = level;
				currSum = u.val;
			}

			if (u.left != null) {
				q1.offer(u.left);
				q2.offer(level + 1);
			}
			if (u.right != null) {
				q1.offer(u.right);
				q2.offer(level + 1);
			}
		}
		return currSum > s ? currLevel : l;
	}

	static int maxLevelSumDfs(TreeNode root) {
		final List<Integer> levelSum = new ArrayList<>();
		levelSum.add(Integer.MIN_VALUE);
		dfs(root, 1, levelSum);

		int l = 0;
		int s = Integer.MIN_VALUE;
		final int n = levelSum.size();
		for (int i = 1; i < n; i++) {
			int currSum = levelSum.get(i);
			if (currSum > s) {
				l = i;
				s = currSum;
			}
		}
		return l;
	}

	static void dfs(TreeNode root, int level, List<Integer> levelSum) {
		if (root == null)
			return;

		if (levelSum.size() == level)
			levelSum.add(root.val);
		else
			levelSum.set(level, levelSum.get(level) + root.val);

		dfs(root.left, level + 1, levelSum);
		dfs(root.right, level + 1, levelSum);
	}
}
