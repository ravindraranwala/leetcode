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
		System.out.println(listAsString(reverseList(head)));
		System.out.println(listAsString(reverseList(head2)));
		System.out.println(listAsString(reverseList(null)));

		final ListNode<Integer> head3 = new ListNode<>(1);
		final ListNode<Integer> n5 = new ListNode<>(2, null);
		head3.next = n5;
		System.out.println(listAsString(reverseList(head3)));
	}

	static <T> ListNode<T> reverseList(ListNode<T> head) {
		ListNode<T> curr = head;
		ListNode<T> prev = null;
		while(curr != null) {
			final ListNode<T> nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		return prev;
	}
	
	static <T> ListNode<T> reverseLinkedList(ListNode<T> node) {
		if (node == null || node.next == null)
			return node;
		final ListNode<T> head = reverseLinkedList(node.next);
		node.next.next = node;
		node.next = null;
		return head;
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
