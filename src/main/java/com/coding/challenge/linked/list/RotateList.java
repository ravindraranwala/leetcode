package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class RotateList {
	RotateList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
		assert "45123".equals(rotateRight(head1, 2).toString());

		final ListNode<Integer> head2 = new ListNode<>(0, new ListNode<>(1, new ListNode<>(2)));
		assert "201".equals(rotateRight(head2, 4).toString());
	}

	static ListNode<Integer> rotateRight(ListNode<Integer> head, int k) {
		if (head == null)
			return head;

		int n = 1;
		ListNode<Integer> curr = head;
		while (curr.next != null) {
			n = n + 1;
			curr = curr.next;
		}
		final int d = k % n;
		if (d == 0)
			return head;

		curr.next = head;
		ListNode<Integer> tail = head;
		for (int i = 1; i < n - d; i++)
			tail = tail.next;

		final ListNode<Integer> newHead = tail.next;
		tail.next = null;
		return newHead;
	}
}
