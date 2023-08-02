package com.coding.challenge.dc;

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
		int n = 0;
		for (ListNode<Integer> curr = head; curr != null; curr = curr.next)
			n = n + 1;
		final int[] nums = new int[n];
		ListNode<Integer> curr = head;
		for (int i = 0; i < n; i++) {
			nums[i] = curr.val;
			curr = curr.next;
		}
		return heightBalancedBst(nums, 0, n - 1);
	}

	private static TreeNode heightBalancedBst(int[] nums, int i, int j) {
		if (i == j)
			return new TreeNode(nums[i]);
		// since we always take the upper median.
		if (i > j)
			return null;
		final int m = i + (j - i + 1) / 2;
		final TreeNode left = heightBalancedBst(nums, i, m - 1);
		final TreeNode right = heightBalancedBst(nums, m + 1, j);
		return new TreeNode(nums[m], left, right);
	}
}
