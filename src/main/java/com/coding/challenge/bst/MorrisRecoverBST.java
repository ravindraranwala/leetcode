package com.coding.challenge.bst;

class MorrisRecoverBST {
	MorrisRecoverBST() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode t1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
		System.out.println(t1);
		recoverTree(t1);
		System.out.println(t1);

		final TreeNode t2 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
		System.out.println(t2);
		recoverTree(t2);
		System.out.println(t2);

		final TreeNode t3 = new TreeNode(2, new TreeNode(3), new TreeNode(1));
		System.out.println(t3);
		recoverTree(t3);
		System.out.println(t3);

		final TreeNode t4 = new TreeNode(146,
				new TreeNode(71, new TreeNode(55, new TreeNode(321, new TreeNode(-33), null), null), null),
				new TreeNode(-13, new TreeNode(231), new TreeNode(399)));
		System.out.println(t4);
		recoverTree(t4);
		System.out.println(t4);

		final TreeNode t5 = new TreeNode(3, null, new TreeNode(1, new TreeNode(2), null));
		System.out.println(t5);
		recoverTree(t5);
		System.out.println(t5);
		
		final TreeNode t6 = new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), null);
		System.out.println(t6);
		recoverTree(t6);
		System.out.println(t6);

	}

	static void recoverTree(TreeNode root) {
		TreeNode curr = root;
		TreeNode p = new TreeNode(Integer.MIN_VALUE);
		TreeNode s1 = null;
		TreeNode s2 = null;

		while (curr != null) {
			if (curr.left == null) {
				if (p.val > curr.val) {
					if (s1 == null)
						s1 = p;
					s2 = curr;
				}
				p = curr;
				curr = curr.right;
			} else {
				// find the inorder predecesor of the current node.
				TreeNode pred = curr.left;
				while (pred.right != null && pred.right != curr)
					pred = pred.right;
				if (pred.right == null) {
					pred.right = curr;
					curr = curr.left;
				} else {
					pred.right = null;
					if (p.val > curr.val) {
						if (s1 == null)
							s1 = p;
						s2 = curr;
					}
					p = curr;
					curr = curr.right;
				}
			}
		}
		// swap it
		final int tmp = s1.val;
		s1.val = s2.val;
		s2.val = tmp;
	}
}
