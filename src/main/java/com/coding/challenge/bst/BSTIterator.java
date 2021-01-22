package com.coding.challenge.bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

class BSTIterator {
	private final Deque<TreeNode> s = new ArrayDeque<>();
	private TreeNode r = null;
	private TreeNode current;

	public static void main(String[] args) {
		// Setting up the BST first.
		final TreeNode rightSubtree = new TreeNode(15);
		rightSubtree.left = new TreeNode(9);
		rightSubtree.right = new TreeNode(20);

		final TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = rightSubtree;

//		TreeNode root = new TreeNode(15);
//		TreeNode three = new TreeNode(3);
//		three.left = new TreeNode(2);
//		three.right = new TreeNode(4);
//
//		TreeNode six = new TreeNode(6);
//		TreeNode seven = new TreeNode(7);
//		TreeNode thirteen = new TreeNode(13);
//		thirteen.left = new TreeNode(9);
//		seven.right = thirteen;
//		six.right = seven;
//		six.left = three;
//
//		TreeNode eighteen = new TreeNode(18);
//		eighteen.left = new TreeNode(17);
//		eighteen.right = new TreeNode(20);
//
//		root.left = six;
//		root.right = eighteen;

		final BSTIterator iterator = new BSTIterator(root);
//		while (iterator.hasNext())
//			System.out.println(iterator.next());

		System.out.println(iterator.next()); // return 3
		System.out.println(iterator.next()); // return 7
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 9
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 15
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next()); // return 20
		System.out.println(iterator.hasNext()); // return false

		Collection<Integer> vals = inorderTraversal(root);
		System.out.println(vals);
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		final Deque<TreeNode> s = new ArrayDeque<>();
		TreeNode current = root;
		final List<Integer> vals = new ArrayList<>();
		while (!s.isEmpty() || current != null) {
			if (current != null) {
				s.push(current);
				current = current.left;
			} else {
				final TreeNode r = s.pop();
				vals.add(r.val);
				current = r.right;
			}
		}
		return vals;
	}

	BSTIterator(TreeNode root) {
		current = root;
	}

	/** @return the next smallest number */
	public int next() {
		while (true) {
			if (current != null) {
				s.push(current);
				current = current.left;
			} else {
				r = s.pop();
				current = r.right;
				return r.val;
			}
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty() || current != null;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
