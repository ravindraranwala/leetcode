package com.coding.challenge.two.pointer;

import com.coding.challenge.ListNode;

class SwappingNodesInLinkedList {
	SwappingNodesInLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
		assert "14325".equals(swapNodes(head1, 2).toString());

		final ListNode<Integer> head2 = new ListNode<>(7,
				new ListNode<>(9, new ListNode<>(6, new ListNode<>(6, new ListNode<>(7, new ListNode<>(8,
						new ListNode<>(3, new ListNode<>(0, new ListNode<>(9, new ListNode<>(5))))))))));
		assert "7966873095".equals(swapNodes(head2, 5).toString());
	}

	static ListNode<Integer> swapNodes(ListNode<Integer> head, int k) {
		ListNode<Integer> nodeOne = head;
		for (int i = 1; i < k; i++)
			nodeOne = nodeOne.next;

		// Two Pointer technique.
		ListNode<Integer> nodeTwo = head;
		for (ListNode<Integer> curr = nodeOne.next; curr != null; curr = curr.next)
			nodeTwo = nodeTwo.next;

		// swap.
		final int tmp = nodeOne.val;
		nodeOne.val = nodeTwo.val;
		nodeTwo.val = tmp;
		return head;
	}
}
