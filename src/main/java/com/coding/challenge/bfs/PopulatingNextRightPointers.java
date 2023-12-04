package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class PopulatingNextRightPointers {
	PopulatingNextRightPointers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final Node rootOne = new Node(1, new Node(2, new Node(4), new Node(5), null),
				new Node(3, new Node(6), new Node(7), null), null);
		System.out.println(connect(rootOne));
	}

	static Node connect(Node root) {
		final Queue<Node> nodesQueue = new ArrayDeque<>();
		final Queue<Integer> levelsQueue = new ArrayDeque<>();
		if (root != null) {
			nodesQueue.offer(root);
			levelsQueue.offer(0);
		}
		while (!nodesQueue.isEmpty()) {
			final Node currNode = nodesQueue.poll();
			final int level = levelsQueue.poll();
			if (currNode.left != null) {
				nodesQueue.offer(currNode.left);
				levelsQueue.offer(level + 1);
			}
			if (currNode.right != null) {
				nodesQueue.offer(currNode.right);
				levelsQueue.offer(level + 1);
			}
			if (!levelsQueue.isEmpty() && level == levelsQueue.peek())
				currNode.next = nodesQueue.peek();
		}
		return root;
	}

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}
}
