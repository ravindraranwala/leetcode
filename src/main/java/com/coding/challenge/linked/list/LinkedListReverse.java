package com.coding.challenge.linked.list;

import java.util.StringJoiner;

import com.coding.challenge.ListNode;

class LinkedListReverse {

	LinkedListReverse() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Testcase 1.
		final ListNode<Integer> head = new ListNode<>(1);
		final ListNode<Integer> n1 = new ListNode<>(2);
		head.next = n1;
		final ListNode<Integer> n2 = new ListNode<>(3);
		n1.next = n2;
		final ListNode<Integer> n3 = new ListNode<>(4);
		n2.next = n3;
		final ListNode<Integer> n4 = new ListNode<>(5, null);
		n3.next = n4;
//		final ListNode reversedList = reverseList(head);
//		System.out.println(listAsString(reversedList));

		// Testcase 2.
		final ListNode<Integer> head2 = new ListNode<>(1, null);
//		System.out.println(listAsString(reverseList(head2)));

		// Test case 3.
//		System.out.println(listAsString(reverseList(null)));

		// Testing the recursive implementation.
		System.out.println(listAsString(reverseLinkedList(head)));
		System.out.println(listAsString(reverseLinkedList(head2)));
		System.out.println(listAsString(reverseLinkedList(null)));

		final ListNode<Integer> head3 = new ListNode<>(1);
		final ListNode<Integer> n5 = new ListNode<>(2, null);
		head3.next = n5;
		System.out.println(listAsString(reverseLinkedList(head3)));
	}

	static <T> ListNode<T> reverseList(ListNode<T> head) {
		if (head == null)
			return head;
		ListNode<T> current = head;
		ListNode<T> next = head.next;
		current.next = null;
		while (next != null) {
			final ListNode<T> previous = current;
			current = next;
			next = current.next;
			current.next = previous;
		}
		return current;
	}

	static <T> ListNode<T> reverseListRec(ListNode<T> node) {
		if (node.next == null)
			return node;
		final ListNode<T> head = reverseListRec(node.next);
		node.next.next = node;
		return head;
	}

	static <T> ListNode<T> reverseLinkedList(ListNode<T> head) {
		if (head == null)
			return head;
		final ListNode<T> h = reverseListRec(head);
		head.next = null;
		return h;
	}

	/**
	 * View/Adapter method that returns the string representation of the given
	 * linked-list.
	 * 
	 * @param listNode head of the linked list.
	 * @return the string representation of the given linked-list.
	 */
	static <T> String listAsString(ListNode<T> listNode) {
		final StringJoiner ll = new StringJoiner(", ", "[", "]");
		for (ListNode<T> current = listNode; current != null; current = current.next)
			ll.add(String.valueOf(current.val));
		return ll.toString();
	}
}
