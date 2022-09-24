package com.coding.challenge.two.pointer;

import com.coding.challenge.ListNode;

class LinkedListMiddle {
	LinkedListMiddle() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> headOne = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
		assert middleNode(headOne).val == 3;

		final ListNode<Integer> headTwo = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, new ListNode<>(6))))));
		assert middleNode(headTwo).val == 4;
	}

	// two-pointer approach example.
	static ListNode<Integer> middleNode(ListNode<Integer> head) {
		// declare the two pointers first.
		ListNode<Integer> m = head;
		ListNode<Integer> t = head;
		while (t != null && t.next != null) {
			t = t.next.next;
			m = m.next;
		}

		return m;
	}
}
