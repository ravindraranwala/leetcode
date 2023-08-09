package com.coding.challenge.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coding.challenge.bst.TreeNode;

class AllElementsInTwoBSTs {
	AllElementsInTwoBSTs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final TreeNode rootOne = new TreeNode(2, new TreeNode(1), new TreeNode(4));
		final TreeNode rootTwo = new TreeNode(1, new TreeNode(0), new TreeNode(3));
		assert Arrays.asList(0, 1, 1, 2, 3, 4).equals(getAllElements(rootOne, rootTwo));

		final TreeNode rootThree = new TreeNode(1, null, new TreeNode(8));
		final TreeNode rootFour = new TreeNode(8, new TreeNode(1), null);
		assert Arrays.asList(1, 1, 8, 8).equals(getAllElements(rootThree, rootFour));
	}

	static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		final List<Integer> left = new ArrayList<>();
		visitTree(root1, left);
		final List<Integer> right = new ArrayList<>();
		visitTree(root2, right);
		final List<Integer> t = new ArrayList<>();
		// merging two sub-lists.
		final int n1 = left.size();
		final int n2 = right.size();
		int i = 0;
		int j = 0;
		while (i < n1 && j < n2) {
			if (left.get(i) < right.get(j)) {
				t.add(left.get(i));
				i = i + 1;
			} else {
				t.add(right.get(j));
				j = j + 1;
			}
		}

		while (i < n1) {
			t.add(left.get(i));
			i = i + 1;
		}

		while (j < n2) {
			t.add(right.get(j));
			j = j + 1;
		}
		return t;
	}

	private static void visitTree(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		visitTree(root.left, l);
		l.add(root.val);
		visitTree(root.right, l);
	}
}
