package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class ReverseNodesInGroup {
	ReverseNodesInGroup() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<Integer>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
		assert "21435".equals(reverseKGroup(head1, 2).toString());

		final ListNode<Integer> head2 = new ListNode<Integer>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
		assert "32145".equals(reverseKGroup(head2, 3).toString());

		final ListNode<Integer> head3 = new ListNode<Integer>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5, new ListNode<>(6))))));
		assert "321654".equals(reverseKGroup(head3, 3).toString());
	}

	static ListNode<Integer> reverseKGroup(ListNode<Integer> head, int k) {
		int n = 0;
		for (ListNode<Integer> curr = head; curr != null; curr = curr.next)
			n = n + 1;
		ListNode<Integer> curr = head;
		final ListNode<Integer> dummyHead = new ListNode<>(-1, head);
		ListNode<Integer> prevGroupFirst = dummyHead;
		final int groupCnt = n / k;
		for (int g = 1; g <= groupCnt; g++) {
			ListNode<Integer> prev = null;
			ListNode<Integer> currGroupFirst = curr;
			ListNode<Integer> currGroupLast = null;
			for (int i = 1; i <= k; i++) {
				final ListNode<Integer> tmp = curr.next;
				curr.next = prev;
				prev = curr;
				currGroupLast = curr;
				curr = tmp;
			}
			prevGroupFirst.next = currGroupLast;
			prevGroupFirst = currGroupFirst;
		}
		if (n % k > 0)
			prevGroupFirst.next = curr;
		return dummyHead.next;
	}
}
