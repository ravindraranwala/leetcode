package com.coding.challenge.bst;

import java.util.ArrayDeque;
import java.util.Deque;

class RecoverBST {
	RecoverBST() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode t1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
		System.out.println(t1);
		iterativeInorderRecoverBst(t1);
		System.out.println(t1);

		final TreeNode t2 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
		System.out.println(t2);
		iterativeInorderRecoverBst(t2);
		System.out.println(t2);

		final TreeNode t3 = new TreeNode(2, new TreeNode(3), new TreeNode(1));
		System.out.println(t3);
		iterativeInorderRecoverBst(t3);
		System.out.println(t3);

		final TreeNode t4 = new TreeNode(146,
				new TreeNode(71, new TreeNode(55, new TreeNode(321, new TreeNode(-33), null), null), null),
				new TreeNode(-13, new TreeNode(231), new TreeNode(399)));
		System.out.println(t4);
		iterativeInorderRecoverBst(t4);
		System.out.println(t4);

		final TreeNode t5 = new TreeNode(3, null, new TreeNode(1, new TreeNode(2), null));
		System.out.println(t5);
		iterativeInorderRecoverBst(t5);
		System.out.println(t5);

		final TreeNode t6 = new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), null);
		System.out.println(t6);
		iterativeInorderRecoverBst(t6);
		System.out.println(t6);
	}

	static void iterativeInorderRecoverBst(TreeNode root) {
		TreeNode curr = root;
		final Deque<TreeNode> s = new ArrayDeque<>();
		TreeNode p = new TreeNode(Integer.MIN_VALUE);
		TreeNode s1 = null;
		TreeNode s2 = null;
		while (curr != null || !s.isEmpty()) {
			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				final TreeNode n = s.pop();
				if (s1 == null && p.val > n.val) {
					s1 = p;
					s2 = n;
				}
				if (s1 != null && s2.val > n.val)
					s2 = n;
				curr = n.right;
				p = n;
			}
		}
		// swap it
		final int tmp = s1.val;
		s1.val = s2.val;
		s2.val = tmp;
	}
}
