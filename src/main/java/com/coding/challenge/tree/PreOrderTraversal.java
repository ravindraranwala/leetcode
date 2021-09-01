package com.coding.challenge.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class PreOrderTraversal {

	PreOrderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		two.left = three;
		one.right = two;
		final List<Integer> preOrder1 = preorderTraversal(one);
		System.out.println(preOrder1);
		
		// Usecase 2.
		final List<Integer> preOrder2 = preorderTraversal(null);
		System.out.println(preOrder2);
		
		// Usecase 3.
		final List<Integer> preOrder3 = preorderTraversal(new TreeNode(1));
		System.out.println(preOrder3);
		
		// Usecase 4.
		final TreeNode one1 = new TreeNode(1);
		final TreeNode two1 = new TreeNode(2);
		one1.left = two1;
		List<Integer> preOrder4 = preorderTraversal(one1);
		System.out.println(preOrder4);
		
		// Usecase 5.
		final TreeNode one2 = new TreeNode(1);
		final TreeNode two2 = new TreeNode(2);
		one2.right = two2;
		List<Integer> preOrder5 = preorderTraversal(one2);
		System.out.println(preOrder5);
		
		// Usecase 6.
		final TreeNode one3 = new TreeNode(1);
		final TreeNode two3 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		one3.left = two3;
		one3.right = new TreeNode(3);
		List<Integer> preOrder6 = preorderTraversal(one3);
		System.out.println(preOrder6);
	}

	static List<Integer> preorderTraversal(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		final Deque<TreeNode> s = new ArrayDeque<>();
		if (root != null)
			s.push(root);
		while (!s.isEmpty()) {
			final TreeNode node = s.pop();
			l.add(node.val);
			if (node.right != null)
				s.push(node.right);
			if (node.left != null)
				s.push(node.left);
		}
		return l;
	}
}
