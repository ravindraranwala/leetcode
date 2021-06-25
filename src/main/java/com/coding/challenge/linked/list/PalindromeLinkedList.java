package com.coding.challenge.linked.list;

class PalindromeLinkedList {

	PalindromeLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode head = new ListNode(1);
		final ListNode n1 = new ListNode(2);
		head.next = n1;
		final ListNode n2 = new ListNode(3);
		n1.next = n2;
		final ListNode n3 = new ListNode(2);
		n2.next = n3;
		final ListNode n4 = new ListNode(1, null);
		n3.next = n4;
		System.out.println(isPalindrome(head));
	}

	static boolean isPalindrome(ListNode head) {
		if (head == null)
			throw new IllegalArgumentException("Empty list.");
		int counter = 0;
		for (ListNode current = head; current != null; current = current.next)
			counter++;

		if (counter == 1)
			return true;
		ListNode current = head;
		ListNode next = head.next;
		current.next = null;
		for (int i = 1; i < counter / 2; i++) {
			final ListNode previous = current;
			current = next;
			next = current.next;
			current.next = previous;
		}

		// current pointer sets to the middle of the linkedlist now.
		ListNode lowerRight = next;
		if (counter % 2 != 0)
			lowerRight = lowerRight.next;
		boolean isPalind = true;

		while (current != null && lowerRight != null) {
			if (isPalind && current.val != lowerRight.val)
				isPalind = false;
			lowerRight = lowerRight.next;
			// Fix the pointer rearrangement again.
			final ListNode previous = current.next;
			current.next = next;
			next = current;
			current = previous;
		}
		return isPalind;
	}
	
	static boolean isPalindromeNoFixation(ListNode head) {
		if (head == null)
			throw new IllegalArgumentException("Empty list.");
		int counter = 0;
		for (ListNode current = head; current != null; current = current.next)
			counter++;

		if (counter == 1)
			return true;
		ListNode current = head;
		ListNode next = head.next;
		current.next = null;
		for (int i = 1; i < counter / 2; i++) {
			final ListNode previous = current;
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

	/**
	 * Definition for singly-linked list.
	 */
	static class ListNode {
		final int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
