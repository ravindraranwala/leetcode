package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

import com.coding.challenge.bst.TreeNode;

class CBTInserter {
	private Queue<TreeNode> q = new ArrayDeque<>();
	final TreeNode root;

	public CBTInserter(TreeNode root) {
		this.root = root;
		q.offer(root);
		while (q.peek().left != null && q.peek().right != null) {
			final TreeNode node = q.poll();
			q.offer(node.left);
			q.offer(node.right);
		}
		final TreeNode firstNode = q.peek();
		if (firstNode.left != null)
			q.offer(firstNode.left);
	}

	public static void main(String[] args) {
		final CBTInserter cBTInserter = new CBTInserter(new TreeNode(1, new TreeNode(2), null));
		assert cBTInserter.insert(3) == 1; // return 1
		assert cBTInserter.insert(4) == 2; // return 2
		assert "[4, 2, 1, 3]".equals(cBTInserter.get_root().toString()); // return [1, 2, 3, 4]
	}

	public int insert(int val) {
		final TreeNode p = q.peek();
		final TreeNode node = new TreeNode(val);
		q.offer(node);
		if (p.left == null)
			p.left = node;
		else {
			p.right = node;
			q.poll();
		}
		return p.val;
	}

	public TreeNode get_root() {
		return root;
	}
}
