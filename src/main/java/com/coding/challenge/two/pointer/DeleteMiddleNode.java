package com.coding.challenge.two.pointer;

import com.coding.challenge.ListNode;

class DeleteMiddleNode {
	DeleteMiddleNode() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> headOne = new ListNode<Integer>(1, new ListNode<>(3,
				new ListNode<>(4, new ListNode<>(7, new ListNode<>(1, new ListNode<>(2, new ListNode<>(6)))))));
		assert "134126".equals(deleteMiddle(headOne).toString());

		final ListNode<Integer> headTwo = new ListNode<Integer>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4))));
		assert "124".equals(deleteMiddle(headTwo).toString());

		final ListNode<Integer> headThree = new ListNode<Integer>(2, new ListNode<>(1));
		assert "2".equals(deleteMiddle(headThree).toString());

		final ListNode<Integer> headFour = new ListNode<Integer>(1);
		assert deleteMiddle(headFour) == null;
	}

	static ListNode<Integer> deleteMiddle(ListNode<Integer> head) {
		final ListNode<Integer> dummyHead = new ListNode<Integer>(0, head);
		ListNode<Integer> l = dummyHead;
		ListNode<Integer> h = dummyHead;
		while (h.next != null && h.next.next != null) {
			l = l.next;
			h = h.next.next;
		}
		// delete the node
		l.next = l.next.next;
		return dummyHead.next;
	}
}
