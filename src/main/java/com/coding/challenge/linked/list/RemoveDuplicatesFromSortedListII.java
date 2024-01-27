package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class RemoveDuplicatesFromSortedListII {
	RemoveDuplicatesFromSortedListII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(1, new ListNode<>(2,
				new ListNode<>(3, new ListNode<>(3, new ListNode<>(4, new ListNode<>(4, new ListNode<>(5)))))));
		assert "125".equals(deleteDuplicates(head1).toString());

		final ListNode<Integer> head2 = new ListNode<>(1,
				new ListNode<>(1, new ListNode<>(1, new ListNode<>(2, new ListNode<>(3)))));
		assert "23".equals(deleteDuplicates(head2).toString());

		final ListNode<Integer> head3 = new ListNode<Integer>(1,
				new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(3)))));
		assert "2".equals(deleteDuplicates(head3).toString());

		final ListNode<Integer> head4 = new ListNode<Integer>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(3, new ListNode<>(3)))));
		assert "12".equals(deleteDuplicates(head4).toString());
	}

	static ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
		final ListNode<Integer> dummy = new ListNode<>(0);
		ListNode<Integer> curr2 = dummy;
		for (ListNode<Integer> curr1 = head; curr1 != null; curr1 = curr1.next) {
			if (curr1.next == null || curr1.val != curr1.next.val) {
				curr2.next = new ListNode<>(curr1.val);
				curr2 = curr2.next;
			}
			while (curr1.next != null && curr1.val == curr1.next.val)
				curr1 = curr1.next;
		}
		return dummy.next;
	}
}
