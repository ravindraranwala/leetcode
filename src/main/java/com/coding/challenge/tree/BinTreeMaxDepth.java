package com.coding.challenge.tree;

import com.coding.challenge.bst.TreeNode;

class BinTreeMaxDepth {
	BinTreeMaxDepth() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode three = new TreeNode(3);
		final TreeNode nine = new TreeNode(9);
		three.left = nine;
		final TreeNode twenty = new TreeNode(20);
		final TreeNode fifteen = new TreeNode(15);
		final TreeNode seven = new TreeNode(7);
		twenty.left = fifteen;
		twenty.right = seven;
		three.right = twenty;
		int depth = maxDepth(three);
		System.out.println(String.format("Max depth of Binary tree is: %d", depth));
		
		// Usecase 2
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		one.right = two;
		depth = maxDepth(one);
		System.out.println(String.format("Max depth of Binary tree is: %d", depth));
		
		// Usecase 3
		depth = maxDepth(null);
		System.out.println(String.format("Max depth of Binary tree is: %d", depth));
		
		// Usecase 4
		depth = maxDepth(new TreeNode(0));
		System.out.println(String.format("Max depth of Binary tree is: %d", depth));
	}

    static int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        final int l = maxDepth(root.left);
        final int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
