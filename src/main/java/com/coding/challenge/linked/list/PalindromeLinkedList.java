package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class PalindromeLinkedList {
	PalindromeLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
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
		System.out.println(head);

		// Usecase 2.
		final ListNode<Integer> one = new ListNode<>(1);
		final ListNode<Integer> two = new ListNode<>(2);
		one.next = two;
		final ListNode<Integer> two2 = new ListNode<>(2);
		two.next = two2;
		final ListNode<Integer> one2 = new ListNode<>(1);
		two2.next = one2;
		System.out.println(isPalindrome(one));
		System.out.println(one);

		// Usecase 3.
		final ListNode<Integer> one3 = new ListNode<>(1);
		one3.next = new ListNode<>(2);
		System.out.println(isPalindrome(one3));
		System.out.println(one3);
	}

	static <T> boolean isPalindrome(ListNode<T> head) {
		int c = 0;
		for (ListNode<T> curr = head; curr != null; curr = curr.next)
			c = c + 1;
		final int mid = (c + 1) / 2;
		ListNode<T> l = head;
		ListNode<T> r = head;
		for (int i = 1; i < mid; i++)
			r = r.next;
		ListNode<T> nxt = r.next;
		while (nxt != null) {
			final ListNode<T> tmp = nxt.next;
			nxt.next = r;
			r = nxt;
			nxt = tmp;
		}
		boolean p = true;
		for (int i = 1; i <= mid; i++) {
			if (l.val != r.val)
				p = false;
			l = l.next;
			final ListNode<T> tmp = r.next;
			r.next = nxt;
			nxt = r;
			r = tmp;
		}
		return p;
	}
}
