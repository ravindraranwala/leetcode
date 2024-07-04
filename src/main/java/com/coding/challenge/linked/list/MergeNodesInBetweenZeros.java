package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class MergeNodesInBetweenZeros {
	MergeNodesInBetweenZeros() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> h1 = new ListNode<Integer>(0, new ListNode<>(3, new ListNode<>(1,
				new ListNode<>(0, new ListNode<>(4, new ListNode<>(5, new ListNode<>(2, new ListNode<>(0))))))));
		final ListNode<Integer> ans1 = new ListNode<>(4, new ListNode<>(11));
		assert ans1.toString().equals(mergeNodes(h1).toString());

		final ListNode<Integer> h2 = new ListNode<>(0, new ListNode<>(1, new ListNode<>(0,
				new ListNode<>(3, new ListNode<>(0, new ListNode<>(2, new ListNode<>(2, new ListNode<>(0))))))));
		final ListNode<Integer> ans2 = new ListNode<>(1, new ListNode<>(3, new ListNode<>(4)));
		assert ans2.toString().equals(mergeNodes(h2).toString());
	}

	static ListNode<Integer> mergeNodes(ListNode<Integer> head) {
		final ListNode<Integer> dummyHead = new ListNode<>(-1);
		int s = 0;
		for (ListNode<Integer> curr = head.next, last = dummyHead; curr != null; curr = curr.next) {
			s = s + curr.val;
			if (curr.val == 0) {
				last.next = new ListNode<>(s);
				last = last.next;
				s = 0;
			}
		}
		return dummyHead.next;
	}
}
