package com.coding.challenge.tree;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class MorrisInorderTraversal {

	MorrisInorderTraversal() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final TreeNode one = new TreeNode(1);
		final TreeNode two = new TreeNode(2);
		final TreeNode three = new TreeNode(3);
		one.right = two;
		two.left = three;
		List<Integer> vals = morrisInorderTraversal(one);
		System.out.println(vals);

		// Usecase 2.
		vals = morrisInorderTraversal(null);
		System.out.println(vals);
		
		// Usecase 3.
		vals = morrisInorderTraversal(new TreeNode(1));
		System.out.println(vals);
		
		// Usecase 4.
		final TreeNode one2 = new TreeNode(1);
		one2.left = new TreeNode(2);
		vals = morrisInorderTraversal(one2);
		System.out.println(vals);
		
		// Usecase 5.
		final TreeNode one3 = new TreeNode(1);
		one3.right = new TreeNode(2);
		vals = morrisInorderTraversal(one3);
		System.out.println(vals);
	}

	static List<Integer> morrisInorderTraversal(TreeNode root) {
		final List<Integer> r = new ArrayList<>();
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left == null) {
				r.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode pre = curr.left;
				while (pre.right != null && pre.right != curr)
					pre = pre.right;

				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre.right = null;
					r.add(curr.val);
					curr = curr.right;
				}
			}
		}
		return r;
	}
}
