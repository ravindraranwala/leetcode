package com.coding.challenge.dc;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.ListNode;
import com.coding.challenge.bst.TreeNode;

class ConvertSortedListToBinarySearchTree {
	ConvertSortedListToBinarySearchTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> treeOne = new ListNode<Integer>(-10,
				new ListNode<>(-3, new ListNode<>(0, new ListNode<>(5, new ListNode<>(9)))));
		System.out.println(sortedListToBST(treeOne));

		System.out.println(sortedListToBST(null));

		final ListNode<Integer> treeThree = new ListNode<Integer>(0,
				new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5))))));
		System.out.println(sortedListToBST(treeThree));
	}

	static TreeNode sortedListToBST(ListNode<Integer> head) {
		final List<Integer> nums = new ArrayList<>();
		for (ListNode<Integer> curr = head; curr != null; curr = curr.next)
			nums.add(curr.val);
		return heightBalancedBst(nums, 0, nums.size() - 1);
	}

	private static TreeNode heightBalancedBst(List<Integer> nums, int i, int j) {
		if (i == j)
			return new TreeNode(nums.get(i));
		// since we always take the upper median.
		if (i > j)
			return null;
		final int m = i + (j - i + 1) / 2;
		final TreeNode left = heightBalancedBst(nums, i, m - 1);
		final TreeNode right = heightBalancedBst(nums, m + 1, j);
		return new TreeNode(nums.get(m), left, right);
	}
}
