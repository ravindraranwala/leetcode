package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class CousinsInBinaryTreeII {
	CousinsInBinaryTreeII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode root1 = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(10)),
				new TreeNode(9, null, new TreeNode(7)));
		final TreeNode cousinRoot1 = replaceValueInTree(root1);
		System.out.println(cousinRoot1);

		final TreeNode root2 = new TreeNode(3, new TreeNode(1), new TreeNode(2));
		final TreeNode cousinRoot2 = replaceValueInTree(root2);
		System.out.println(cousinRoot2);
	}

	static TreeNode replaceValueInTree(TreeNode root) {
		final List<Integer> l = new ArrayList<>();
		levelSum(root, 0, l);
		buildCousinTree(root, 0, l, 0);
		return root;
	}

	private static void levelSum(TreeNode root, int h, List<Integer> s) {
		if (root == null)
			return;
		if (h == s.size())
			s.add(root.val);
		else
			s.set(h, s.get(h) + root.val);
		levelSum(root.left, h + 1, s);
		levelSum(root.right, h + 1, s);
	}

	private static void buildCousinTree(TreeNode curr, int h, List<Integer> s, int siblingVal) {
		if (curr == null)
			return;

		curr.val = s.get(h) - curr.val - siblingVal;
		int leftVal = 0;
		int rightVal = 0;
		if (curr.left != null)
			leftVal = curr.left.val;
		if (curr.right != null)
			rightVal = curr.right.val;

		buildCousinTree(curr.left, h + 1, s, rightVal);
		buildCousinTree(curr.right, h + 1, s, leftVal);
	}
}
