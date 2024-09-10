package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class InsertGreatestCommonDivisorsInLinkedList {
	InsertGreatestCommonDivisorsInLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(18, new ListNode<>(6, new ListNode<>(10, new ListNode<>(3))));
		System.out.println(insertGreatestCommonDivisors(head1));

		System.out.println(insertGreatestCommonDivisors(new ListNode<>(7)));
	}

	static ListNode<Integer> insertGreatestCommonDivisors(ListNode<Integer> head) {
		for (ListNode<Integer> curr = head; curr.next != null; curr = curr.next.next) {
			final ListNode<Integer> next = curr.next;
			final ListNode<Integer> gcdNode = new ListNode<>(
					gcd(Math.max(curr.val, next.val), Math.min(curr.val, next.val)), next);
			curr.next = gcdNode;
		}
		return head;
	}

	// Euclidean Algorithm for finding the GCD.
	private static int gcd(int m, int n) {
		if (n == 0)
			return m;

		return gcd(n, m % n);
	}
}
