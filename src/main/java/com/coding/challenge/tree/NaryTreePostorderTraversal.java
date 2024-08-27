package com.coding.challenge.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class NaryTreePostorderTraversal {
	NaryTreePostorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final Node root1 = new Node(1,
				Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
		assert Arrays.asList(5, 6, 3, 2, 4, 1).equals(postorder(root1));
	}

	static List<Integer> postorder(Node root) {
		if (root == null)
			return Collections.emptyList();
		final List<Integer> l = new ArrayList<>();
		postorderTreeWalk(root, l);
		return l;
	}

	private static void postorderTreeWalk(Node root, List<Integer> l) {
		for (Node c : root.children)
			postorderTreeWalk(c, l);

		l.add(root.val);
	}

	private static class Node {
		public int val;
		public List<Node> children = Collections.emptyList();

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}
}
