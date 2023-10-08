package com.coding.challenge.two.pointer;

import com.coding.challenge.ListNode;

class MaximumTwinSumOfLinkedList {
	MaximumTwinSumOfLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> listOne = new ListNode<>(5, new ListNode<>(4, new ListNode<>(2, new ListNode<>(1))));
		assert pairSum(listOne) == 6;

		final ListNode<Integer> listTwo = new ListNode<>(4, new ListNode<>(2, new ListNode<>(2, new ListNode<>(3))));
		assert pairSum(listTwo) == 7;

		final ListNode<Integer> listThree = new ListNode<>(1, new ListNode<>(100000));
		assert pairSum(listThree) == 100001;
	}

	static int pairSum(ListNode<Integer> head) {
		// find the middle of the linked list first.
		ListNode<Integer> l = head;
		ListNode<Integer> h = head;
		while (h != null) {
			l = l.next;
			h = h.next.next;
		}

		// Now reverse the second half of the linked list.
		ListNode<Integer> prev = null;
		while (l != null) {
			final ListNode<Integer> tmp = l.next;
			l.next = prev;
			prev = l;
			l = tmp;
		}

		ListNode<Integer> tail = prev;
		int sum = 0;
		while (tail != null) {
			sum = Math.max(sum, head.val + tail.val);
			head = head.next;
			tail = tail.next;
		}
		return sum;
	}
}
