package com.coding.challenge.prefix.sum;

import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.ListNode;

class RemoveZeroSumConsecutiveNodesFromLinkedList {
	RemoveZeroSumConsecutiveNodesFromLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(-3, new ListNode<>(3, new ListNode<>(1)))));
		assert "31".equals(removeZeroSumSublists(head1).toString());

		final ListNode<Integer> head2 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(-3, new ListNode<>(4)))));
		assert "124".equals(removeZeroSumSublists(head2).toString());

		final ListNode<Integer> head3 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(-3, new ListNode<>(-2)))));
		assert "1".equals(removeZeroSumSublists(head3).toString());

		final ListNode<Integer> head4 = new ListNode<>(1, new ListNode<>(3, new ListNode<>(2, new ListNode<>(-3,
				new ListNode<>(-2, new ListNode<>(5, new ListNode<>(5, new ListNode<>(-5, new ListNode<>(1)))))))));
		assert "151".equals(removeZeroSumSublists(head4).toString());
	}

	static ListNode<Integer> removeZeroSumSublists(ListNode<Integer> head) {
		final ListNode<Integer> dummyHead = new ListNode<>(0, head);
		final Map<Integer, ListNode<Integer>> preSumLastNode = new HashMap<>();
		int preSum = 0;
		for (ListNode<Integer> curr = dummyHead; curr != null; curr = curr.next) {
			preSum = preSum + curr.val;
			preSumLastNode.put(preSum, curr);
		}

		int sum = 0;
		for (ListNode<Integer> curr = dummyHead; curr != null; curr = curr.next) {
			sum = sum + curr.val;
			curr.next = preSumLastNode.get(sum).next;
		}
		return dummyHead.next;
	}
}
