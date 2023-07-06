package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;
import com.coding.challenge.two.pointer.LinkedListMiddle;

class ReorderList {
	ReorderList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> headOne = new ListNode<Integer>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4))));
		reorderList(headOne);
		assert "1423".equals(headOne.toString());

		final ListNode<Integer> headTwo = new ListNode<Integer>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
		reorderList(headTwo);
		assert "15243".equals(headTwo.toString());

		ListNode<Integer> headThree = new ListNode<Integer>(1, new ListNode<>(2, new ListNode<>(3)));
		reorderList(headThree);
		assert "132".equals(headThree.toString());

		ListNode<Integer> headFour = new ListNode<Integer>(1, new ListNode<>(2));
		reorderList(headFour);
		assert "12".equals(headFour.toString());

		ListNode<Integer> headFive = new ListNode<Integer>(1);
		reorderList(headFive);
		assert "1".equals(headFive.toString());
	}

	static void reorderList(ListNode<Integer> head) {
		final ListNode<Integer> mid = LinkedListMiddle.middleNode(head);
		if (mid == head)
			return;
		final ListNode<Integer> tail = LinkedListReverse.reverseList(mid);
		// two pointer solution.
		ListNode<Integer> l = head;
		ListNode<Integer> h = tail;
		while (l.next != mid) {
			final ListNode<Integer> nextLow = l.next;
			l.next = h;
			final ListNode<Integer> nextHigh = h.next;
			h.next = nextLow;
			l = nextLow;
			h = nextHigh;
		}
		l.next = h;
	}
}
