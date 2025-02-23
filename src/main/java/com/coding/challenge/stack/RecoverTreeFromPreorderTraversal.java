package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import com.coding.challenge.bst.TreeNode;

class RecoverTreeFromPreorderTraversal {
	private static final char ZERO = '0';
	private static final char DASH = '-';

	RecoverTreeFromPreorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(recoverFromPreorder("1-2--3--4-5--6--7"));
		System.out.println(recoverFromPreorder("1-2--3---4-5--6---7"));
		System.out.println(recoverFromPreorder("1-401--349---90--88"));
	}

	static TreeNode recoverFromPreorder(String traversal) {
		final int n = traversal.length();
		final Deque<Integer> heightStack = new ArrayDeque<>();
		final Deque<TreeNode> nodeStack = new ArrayDeque<>();
		final TreeNode root = new TreeNode(0);
		int i = 0;
		while (i < n && traversal.charAt(i) != DASH) {
			root.val = root.val * 10 + traversal.charAt(i) - ZERO;
			i = i + 1;
		}
		heightStack.push(0);
		nodeStack.push(root);

		while (i < n) {
			int h = 0;
			while (traversal.charAt(i) == DASH) {
				i = i + 1;
				h = h + 1;
			}

			int key = 0;
			while (i < n && traversal.charAt(i) != DASH) {
				key = key * 10 + traversal.charAt(i) - ZERO;
				i = i + 1;
			}

			while (heightStack.peek() >= h) {
				heightStack.pop();
				nodeStack.pop();
			}

			final TreeNode p = nodeStack.peek();
			final TreeNode node = new TreeNode(key);
			if (p.left == null)
				p.left = node;
			else
				p.right = node;

			heightStack.push(h);
			nodeStack.push(node);
		}
		return root;
	}
}
