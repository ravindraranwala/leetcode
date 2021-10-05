package com.coding.challenge.tree;

import java.util.ArrayDeque;

import com.coding.challenge.bst.TreeNode;

class SameTree {
	SameTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode one1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		final TreeNode one2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		boolean same = isSameTree(one1, one2);
		System.out.println(same);

		// Usecase 2.
		same = isSameTree(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, null, new TreeNode(2)));
		System.out.println(same);

		// Usecase 3.
		same = isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
				new TreeNode(1, new TreeNode(1), new TreeNode(2)));
		System.out.println(same);

		// Usecase 4.
		same = isSameTree(null, null);
		System.out.println(same);

		// Usecase 5.
		same = isSameTree(new TreeNode(1), new TreeNode(1, null, new TreeNode(2)));
		System.out.println(same);
	}

	static boolean isSameTree(TreeNode p, TreeNode q) {
		final ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
		final ArrayDeque<TreeNode> s2 = new ArrayDeque<>();
		final TreeNode d = new TreeNode(-1);
		s1.push(d);
		s2.push(d);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (p != null && q != null) {
				if (p.val != q.val)
					return false;
				s1.push(p);
				s2.push(q);
				p = p.left;
				q = q.left;
			} else if (p == null && q == null) {
				p = s1.pop().right;
				q = s2.pop().right;
			} else
				return false;
		}
		return true;
	}
}
