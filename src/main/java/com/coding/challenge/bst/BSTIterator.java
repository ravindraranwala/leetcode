package com.coding.challenge.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

class BSTIterator {
	private final Deque<TreeNode> s = new ArrayDeque<>();
	private TreeNode current = null;
	private TreeNode nextLeft;
	private boolean done;

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

	}

	BSTIterator(TreeNode root) {
		nextLeft = root;
		done = root == null;
	}

	/** @return the next smallest number */
	public int next() {
		while (!done) {
			if (nextLeft != null) {
				s.push(nextLeft);
				nextLeft = nextLeft.left;
			} else {
				current = s.pop();
				if (current.right != null) {
					s.push(current.right);
					nextLeft = current.right.left;
				}
				done = s.isEmpty();
				return current.val;
			}
		}
		throw new NoSuchElementException();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !done;
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
