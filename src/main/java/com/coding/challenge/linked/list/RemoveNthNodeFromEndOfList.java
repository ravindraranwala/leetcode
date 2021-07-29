package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class RemoveNthNodeFromEndOfList {

	RemoveNthNodeFromEndOfList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> one = new ListNode<>(1);
		final ListNode<Integer> two = new ListNode<>(2);
		final ListNode<Integer> three = new ListNode<>(3);
		final ListNode<Integer> four = new ListNode<>(4);
		final ListNode<Integer> five = new ListNode<>(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		ListNode<Integer> head = removeNthFromEnd(one, 2);
		System.out.println(head);

		head = removeNthFromEnd(new ListNode<>(1), 1);
		System.out.println(head);
		
		final ListNode<Integer> one2 = new ListNode<>(1);
		one2.next = new ListNode<>(2);
		head = removeNthFromEnd(one2, 1);
		System.out.println(head);
	}

	static <T> ListNode<T> removeNthFromEnd(ListNode<T> head, int n) {
		ListNode<T> dummy = new ListNode<>(null, head);
		ListNode<T> nDelay = dummy;
		int counter = 0;
		for (ListNode<T> curr = head; curr != null; curr = curr.next) {
			counter++;
			if (counter > n)
				nDelay = nDelay.next;
		}
		nDelay.next = nDelay.next.next;
		return dummy.next;
	}
}
