package com.coding.challenge.two.pointer;

import com.coding.challenge.ListNode;

class DeleteTheMiddleNodeOfLinkedList {
	DeleteTheMiddleNodeOfLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(1, new ListNode<>(3,
				new ListNode<>(4, new ListNode<>(7, new ListNode<>(1, new ListNode<>(2, new ListNode<>(6)))))));
		assert "134126".equals(deleteMiddle(head1).toString());

		final ListNode<Integer> head2 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4))));
		assert "124".equals(deleteMiddle(head2).toString());

		final ListNode<Integer> head3 = new ListNode<>(2, new ListNode<>(1));
		assert "2".equals(deleteMiddle(head3).toString());
	}

	static ListNode<Integer> deleteMiddle(ListNode<Integer> head) {
		final ListNode<Integer> dummyHead = new ListNode<>(-1, head);
		ListNode<Integer> slow = dummyHead;
		ListNode<Integer> fast = dummyHead;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummyHead.next;
	}
}
