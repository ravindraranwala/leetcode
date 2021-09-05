package com.coding.challenge.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class TreeNode {
	public final int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		// We use iterative inorder tree-walk to print the tree here.
		final StringJoiner str = new StringJoiner(", ", "[", "]");
		final Deque<TreeNode> s = new ArrayDeque<>();
		TreeNode curr = this;
		while (!s.isEmpty() || curr != null) {
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				final TreeNode r = s.pop();
				str.add(String.valueOf(r.val));
				curr = r.right;
			}
		}
		return str.toString();
	}
}
