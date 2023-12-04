package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class DoubleNumberRepresentedAsLinkedList {
	DoubleNumberRepresentedAsLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> headOne = new ListNode<>(1, new ListNode<>(8, new ListNode<>(9)));
		assert "378".equals(doubleIt(headOne).toString());

		final ListNode<Integer> headTwo = new ListNode<>(9, new ListNode<>(9, new ListNode<>(9)));
		assert "1998".equals(doubleIt(headTwo).toString());
	}

	static ListNode<Integer> doubleIt(ListNode<Integer> head) {
		// reverse the linked list first.
		ListNode<Integer> curr = head;
		ListNode<Integer> prev = null;
		while (curr != null) {
			final ListNode<Integer> tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		// start from the tail and multiply every node's value by 2.
		ListNode<Integer> doubledHead = null;
		int rem = 0;
		while (prev != null) {
			final int newValue = prev.val * 2 + rem;
			final int key = newValue < 10 ? newValue : newValue - 10;
			rem = newValue / 10;
			final ListNode<Integer> newNode = new ListNode<>(key, doubledHead);
			doubledHead = newNode;
			prev = prev.next;
		}
		if (rem > 0)
			return new ListNode<>(rem, doubledHead);
		return doubledHead;
	}
}
