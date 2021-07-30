package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class PalindromeLinkedList {
	private static ListNode<?> head = null;
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
		
		// Usecase 2.
		final ListNode<Integer> one = new ListNode<>(1);
		final ListNode<Integer> two = new ListNode<>(2);
		one.next = two;
		final ListNode<Integer> two2 = new ListNode<>(2);
		two.next = two2;
		final ListNode<Integer> one2 = new ListNode<>(1);
		two2.next = one2;
		System.out.println(isPalindrome(one));
		
		// Usecase 3.
		final ListNode<Integer> one3 = new ListNode<>(1);
		one3.next = new ListNode<>(2);
		System.out.println(isPalindrome(one3));
	}

	static <T> boolean isPalindrome(ListNode<T> head) {
		PalindromeLinkedList.head = head;
		return palindromeLinkedList(head);
	}

	static <T> boolean palindromeLinkedList(ListNode<T> current) {
		// base case of the recursion
		if (current == null)
			return true;
		boolean p = palindromeLinkedList(current.next);
		p = p && head.val.equals(current.val);
		// advance the pointers to the next level
		head = head.next;
		return p;
	}
}
