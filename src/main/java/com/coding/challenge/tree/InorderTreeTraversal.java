package com.coding.challenge.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class InorderTreeTraversal {

	InorderTreeTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.right = two;
		two.left = three;
		List<Integer> vals = inorderTraversalIterative(one);
		System.out.println(vals);
		vals = inorderTraversal(one);
		System.out.println(vals);

		// Usecase 2.
		vals = inorderTraversalIterative(null);
		System.out.println(vals);
		vals = inorderTraversal(null);
		System.out.println(vals);

		// Usecase 3.
		vals = inorderTraversalIterative(new TreeNode(1));
		System.out.println(vals);
		vals = inorderTraversal(new TreeNode(1));
		System.out.println(vals);

		// Usecase 4.
		final TreeNode one2 = new TreeNode(1);
		one2.left = new TreeNode(2);
		vals = inorderTraversalIterative(one2);
		System.out.println(vals);
		vals = inorderTraversal(one2);
		System.out.println(vals);

		// Usecase 5.
		final TreeNode one3 = new TreeNode(1);
		one3.right = new TreeNode(2);
		vals = inorderTraversalIterative(one3);
		System.out.println(vals);
		vals = inorderTraversal(one3);
		System.out.println(vals);
	}

	static List<Integer> inorderTraversalIterative(TreeNode root) {
		final Deque<TreeNode> s = new ArrayDeque<>();
		final List<Integer> vals = new ArrayList<>();
		TreeNode next = root;
		while (!s.isEmpty() || next != null) {
			if (next != null) {
				s.push(next);
				next = next.left;
			} else {
				final TreeNode n = s.pop();
				vals.add(n.val);
				next = n.right;
			}
		}
		return vals;
	}
	
	static List<Integer> inorderTraversal(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		inorderTraversalRec(root, l);
		return l;
	}

	static void inorderTraversalRec(TreeNode root, List<Integer> vals) {
		if (root != null) {
			inorderTraversalRec(root.left, vals);
			vals.add(root.val);
			inorderTraversalRec(root.right, vals);
		}
	}
}
