package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class LinkedListUtil {
	LinkedListUtil() {
		throw new AssertionError();
	}

	public static void main(String[] args) {

	}

	/**
	 * Returns the nth node from the end of the list.
	 * 
	 * @param <T>
	 * @param head head of the linked list
	 * @param n    This should be a nonnegative number and should lie between 0 and
	 *             the length of the list.
	 * @return The nth node from the end of the list.
	 */
	static <T> ListNode<T> getNthFromEnd(ListNode<T> head, int n) {
		final ListNode<T> dummy = new ListNode<>(null, head);
		ListNode<T> curr = dummy;
		for (int i = 0; i <= n; i++)
			curr = curr.next;
		ListNode<T> delay = dummy;
		while (curr != null) {
			curr = curr.next;
			delay = delay.next;
		}
		return delay;
	}
}
