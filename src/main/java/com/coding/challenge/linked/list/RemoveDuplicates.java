package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class RemoveDuplicates {

	RemoveDuplicates() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final ListNode<Integer> head = new ListNode<>(1);
		final ListNode<Integer> one = new ListNode<>(1);
		head.next = one;
		final ListNode<Integer> two = new ListNode<>(2);
		one.next = two;
		ListNode<Integer> h = deleteDuplicates(head);
		System.out.println(h);

		// Usecase 2
		final ListNode<Integer> one1 = new ListNode<>(1);
		final ListNode<Integer> one2 = new ListNode<>(1);
		one1.next = one2;
		final ListNode<Integer> two2 = new ListNode<>(2);
		one2.next = two2;
		final ListNode<Integer> three = new ListNode<>(3);
		two2.next = three;
		three.next = new ListNode<>(3);
		h = deleteDuplicates(one1);
		System.out.println(h);
	}

	static <T> ListNode<T> deleteDuplicates(ListNode<T> head) {
		ListNode<T> curr = new ListNode<>(null, head);
		while (curr.next != null) {
			if (curr.next.val.equals(curr.val))
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return head;
	}
}
