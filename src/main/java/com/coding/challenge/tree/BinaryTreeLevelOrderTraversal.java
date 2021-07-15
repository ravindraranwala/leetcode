package com.coding.challenge.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.coding.challenge.bst.TreeNode;

/**
 * Implements a variant of the Breadth-First-Search algorithm.
 * 
 * @author ravindra
 *
 */
public class BinaryTreeLevelOrderTraversal {

	private BinaryTreeLevelOrderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode three = new TreeNode(3);
		final TreeNode nine = new TreeNode(9);
		three.left = nine;
		final TreeNode twenty = new TreeNode(20);
		three.right = twenty;
		final TreeNode fifteen = new TreeNode(15);
		final TreeNode seven = new TreeNode(7);
		twenty.left = fifteen;
		twenty.right = seven;

		List<List<Integer>> levelOrder = levelOrder(three);
		System.out.println(levelOrder);

		// Usecase 2.
		final TreeNode one = new TreeNode(1);
		levelOrder = levelOrder(one);
		System.out.println(levelOrder);

		// Usecase 3.
		levelOrder = levelOrder(null);
		System.out.println(levelOrder);
	}

	static List<List<Integer>> levelOrder(TreeNode root) {
		final Queue<TreeNode> q = new ArrayDeque<>();
		final List<List<Integer>> r = new ArrayList<>();
		if (root != null)
			q.offer(root);
		while (!q.isEmpty()) {
			final List<Integer> l = new ArrayList<>();
			final int size = q.size();
			for (int i = 0; i < size; i++) {
				// remove the nodes belong to the current level of the tree.
				final TreeNode n = q.poll();
				l.add(n.val);
				// Add the nodes belong to the next level of the tree to the queue, if they
				// exist.
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
			}
			r.add(l);
		}
		return r;
	}
}
