package com.coding.challenge.dfs;

import com.coding.challenge.ListNode;
import com.coding.challenge.bst.TreeNode;

class LinkedListInBinaryTree {
	private boolean found = false;

	LinkedListInBinaryTree() {
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<Integer>(4, new ListNode<>(2, new ListNode<>(8)));
		final TreeNode root1 = new TreeNode(1, new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)),
				new TreeNode(4, new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))),
						null));
		assert new LinkedListInBinaryTree().isSubPath(head1, root1);

		final ListNode<Integer> head2 = new ListNode<>(1, new ListNode<>(4, new ListNode<>(2, new ListNode<>(6))));
		assert new LinkedListInBinaryTree().isSubPath(head2, root1);
	}

	boolean isSubPath(ListNode<Integer> head, TreeNode root) {
		inorderTreeWalk(head, root);
		return found;
	}

	private void inorderTreeWalk(ListNode<Integer> head, TreeNode root) {
		if (root == null)
			return;
		inorderTreeWalk(head, root.left);
		// what could be my root node? Just try them all.
		dfs(head, root);
		inorderTreeWalk(head, root.right);
	}

	private void dfs(ListNode<Integer> head, TreeNode root) {
		if (head == null) {
			found = true;
			return;
		}
		if (found || root == null || root.val != head.val)
			return;

		dfs(head.next, root.left);
		dfs(head.next, root.right);
	}
}
