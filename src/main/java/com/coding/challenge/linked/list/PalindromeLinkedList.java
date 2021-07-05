package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class PalindromeLinkedList {

	PalindromeLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head = new ListNode<>(1);
		final ListNode<Integer> n1 = new ListNode<>(2);
		head.next = n1;
		final ListNode<Integer> n2 = new ListNode<>(3);
		n1.next = n2;
		final ListNode<Integer> n3 = new ListNode<>(2);
		n2.next = n3;
		final ListNode<Integer> n4 = new ListNode<>(1, null);
		n3.next = n4;
		System.out.println(isPalindrome(head));
	}

	static <T> boolean isPalindrome(ListNode<T> head) {
		if (head == null)
			throw new IllegalArgumentException("Empty list.");
		int counter = 0;
		for (ListNode<T> current = head; current != null; current = current.next)
			counter++;

		if (counter == 1)
			return true;
		ListNode<T> current = head;
		ListNode<T> next = head.next;
		current.next = null;
		for (int i = 1; i < counter / 2; i++) {
			final ListNode<T> previous = current;
			current = next;
			next = current.next;
			current.next = previous;
		}

		// current pointer sets to the middle of the linkedlist now.
		ListNode<T> lowerRight = next;
		if (counter % 2 != 0)
			lowerRight = lowerRight.next;
		boolean isPalind = true;

		while (current != null && lowerRight != null) {
			if (isPalind && current.val != lowerRight.val)
				isPalind = false;
			lowerRight = lowerRight.next;
			// Fix the pointer rearrangement again.
			final ListNode<T> previous = current.next;
			current.next = next;
			next = current;
			current = previous;
		}
		return isPalind;
	}

	static <T> boolean isPalindromeNoFixation(ListNode<T> head) {
		if (head == null)
			throw new IllegalArgumentException("Empty list.");
		int counter = 0;
		for (ListNode<T> current = head; current != null; current = current.next)
			counter++;

		if (counter == 1)
			return true;
		ListNode<T> current = head;
		ListNode<T> next = head.next;
		current.next = null;
		for (int i = 1; i < counter / 2; i++) {
			final ListNode<T> previous = current;
			current = next;
			next = current.next;
			current.next = previous;
		}

		// current pointer sets to the middle of the linkedlist now.
		if (counter % 2 != 0)
			next = next.next;

		while (current != null && next != null) {
			if (current.val != next.val)
				return false;
			next = next.next;
			current = current.next;
		}
		return true;
	}
}
