package com.coding.challenge.linked.list;

import java.util.Arrays;

import com.coding.challenge.ListNode;

class SplitLinkedListInParts {
	SplitLinkedListInParts() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)));
		System.out.println(Arrays.toString(splitListToParts(head1, 5)));

		final ListNode<Integer> head2 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, new ListNode<>(6,
						new ListNode<>(7, new ListNode<>(8, new ListNode<>(9, new ListNode<>(10))))))))));
		System.out.println(Arrays.toString(splitListToParts(head2, 3)));
	}

	static ListNode[] splitListToParts(ListNode<Integer> head, int k) {
		int n = 0;
		for (ListNode<Integer> curr = head; curr != null; curr = curr.next)
			n = n + 1;

		final int minLen = n / k;
		final int maxLen = minLen + 1;
		final int r = n % k;
		final ListNode[] parts = new ListNode[k];
		ListNode<Integer> curr = head;

		for (int i = 0; curr != null; i++) {
			parts[i] = curr;
			ListNode<Integer> tail = curr;
			final int l = i < r ? maxLen : minLen;
			for (int j = 1; j < l; j++) 
				tail = tail.next;

			curr = tail.next;
			tail.next = null;
		}

		return parts;
	}
}
