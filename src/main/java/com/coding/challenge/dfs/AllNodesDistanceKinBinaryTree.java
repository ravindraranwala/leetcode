package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.coding.challenge.bst.TreeNode;

class AllNodesDistanceKinBinaryTree {
	AllNodesDistanceKinBinaryTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode target = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
		final TreeNode root1 = new TreeNode(3, target, new TreeNode(1, new TreeNode(0), new TreeNode(8)));
		System.out.println(distanceK(root1, target, 2));

		final TreeNode root2 = new TreeNode(1);
		System.out.println(distanceK(root2, root2, 3));
	}

	static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		final Map<Integer, List<Integer>> t = new HashMap<>();
		adjList(root, null, t);
		final List<Integer> ans = new ArrayList<>();
		dfs(target.val, k, 0, t, ans, new HashSet<>());
		return ans;
	}

	private static void dfs(Integer u, int k, int h, Map<Integer, List<Integer>> adjList, List<Integer> l, Set<Integer> d) {
		d.add(u);
		if (h == k) {
			l.add(u);
			return;
		}

		for (int v : adjList.get(u))
			if (!d.contains(v))
				dfs(v, k, h + 1, adjList, l, d);
	}

	private static void adjList(TreeNode u, TreeNode p, Map<Integer, List<Integer>> t) {
		if (u == null)
			return;

		t.put(u.val, new ArrayList<>());
		if (p != null) {
			t.get(u.val).add(p.val);
			t.get(p.val).add(u.val);
		}

		adjList(u.left, u, t);
		adjList(u.right, u, t);
	}
}
