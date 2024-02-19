package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class N_aryTreeLevelOrderTraversal {
	private final List<List<Integer>> ans = new ArrayList<>();

	N_aryTreeLevelOrderTraversal() {

	}

	public static void main(String[] args) {
		final Node root1 = new Node(1,
				Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
		final List<List<Integer>> exp1 = Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2, 4), Arrays.asList(5, 6));
		assert exp1.equals(new N_aryTreeLevelOrderTraversal().levelOrder(root1));

		assert Collections.emptyList().equals(new N_aryTreeLevelOrderTraversal().levelOrder(null));
	}

	List<List<Integer>> levelOrder(Node root) {
		preOrder(root, 0);
		return ans;
	}

	private void preOrder(Node root, int l) {
		if (root == null)
			return;
		if (ans.size() == l)
			ans.add(new ArrayList<>());
		ans.get(l).add(root.val);
		if (root.children != null)
			for (Node child : root.children)
				preOrder(child, l + 1);
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
}
