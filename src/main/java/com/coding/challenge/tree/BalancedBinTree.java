package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class BalancedBinTree {
	private static boolean balanced = false;

	BalancedBinTree() {
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
		boolean balanced = isBalanced(three);
		System.out.println(String.format("Binary tree is height balanced: %b", balanced));

		// Usecase 2.
		final TreeNode one = new TreeNode(1);
		final TreeNode two1 = new TreeNode(2);
		final TreeNode two2 = new TreeNode(2);
		one.left = two1;
		one.right = two2;
		final TreeNode three1 = new TreeNode(3);
		final TreeNode three2 = new TreeNode(3);
		two1.left = three1;
		two1.right = three2;
		final TreeNode four1 = new TreeNode(4);
		final TreeNode four2 = new TreeNode(4);
		three1.left = four1;
		three1.right = four2;

		balanced = isBalanced(one);
		System.out.println(String.format("Binary tree is height balanced: %b", balanced));

		// Usecase 3.
		balanced = isBalanced(null);
		System.out.println(String.format("Binary tree is height balanced: %b", balanced));

		// Usecase 4.
		final TreeNode one1 = new TreeNode(1);
		final TreeNode uc4Two1 = new TreeNode(2);
		final TreeNode uc4Two2 = new TreeNode(2);
		one1.left = uc4Two1;
		one1.right = uc4Two2;
		final TreeNode uc4Three1 = new TreeNode(3);
		final TreeNode uc4Three2 = new TreeNode(3);
		uc4Two1.left = uc4Three1;
		uc4Two2.right = uc4Three2;
		uc4Three1.left = new TreeNode(4);
		uc4Three2.right = new TreeNode(4);
		balanced = isBalanced(one1);
		System.out.println(String.format("Binary tree is height balanced: %b", balanced));
	}

	static boolean isBalanced(TreeNode root) {
		balanced = true;
		balancedTree(root);
		return balanced;
	}

	static int balancedTree(TreeNode root) {
		if (root == null)
			return 0;
		final int l = balancedTree(root.left);
		final int r = balancedTree(root.right);
		balanced = balanced && Math.abs(l - r) < 2;
		return Math.max(l, r) + 1;
	}
}
