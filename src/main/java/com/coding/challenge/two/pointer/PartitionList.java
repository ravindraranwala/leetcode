package com.coding.challenge.two.pointer;

import com.coding.challenge.ListNode;

class PartitionList {
	PartitionList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> listOne = new ListNode<>(1,
				new ListNode<>(4, new ListNode<>(3, new ListNode<>(2, new ListNode<>(5, new ListNode<>(2))))));
		assert "122435".equals(partition(listOne, 3).toString());

		final ListNode<Integer> listTwo = new ListNode<Integer>(2, new ListNode<>(1));
		assert "12".equals(partition(listTwo, 2).toString());

		final ListNode<Integer> listThree = new ListNode<Integer>(1, new ListNode<>(4,
				new ListNode<>(3, new ListNode<>(0, new ListNode<>(2, new ListNode<>(5, new ListNode<>(2)))))));
		assert "1022435".equals(partition(listThree, 3).toString());
		
		assert partition(null, 0) == null;
	}

	static ListNode<Integer> partition(ListNode<Integer> head, int x) {
		final ListNode<Integer> dummyHead = new ListNode<>(400, head);
		ListNode<Integer> l = dummyHead;
		while (l.next != null && l.next.val < x)
			l = l.next;

		for (ListNode<Integer> prev = l; prev.next != null;) {
			if (prev.next.val < x) {
				final ListNode<Integer> tmp = prev.next;
				prev.next = prev.next.next;
				tmp.next = l.next;
				l.next = tmp;
				l = l.next;
			} else
				prev = prev.next;
		}
		return dummyHead.next;
	}
}
