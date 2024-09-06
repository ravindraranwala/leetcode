package com.coding.challenge.linked.list;

import java.util.HashSet;
import java.util.Set;

import com.coding.challenge.ListNode;

class DeleteNodesFromLinkedListPresentInArray {
	DeleteNodesFromLinkedListPresentInArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> head1 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
		final int[] nums1 = { 1, 2, 3 };
		assert "45".equals(modifiedList(nums1, head1).toString());

		final ListNode<Integer> head2 = new ListNode<>(1,
				new ListNode<>(2, new ListNode<>(1, new ListNode<>(2, new ListNode<>(1, new ListNode<>(2))))));
		final int[] nums2 = { 1 };
		assert "222".equals(modifiedList(nums2, head2).toString());

		final ListNode<Integer> head3 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4))));
		final int[] nums3 = { 5 };
		assert "1234".equals(modifiedList(nums3, head3).toString());
	}

	static ListNode<Integer> modifiedList(int[] nums, ListNode<Integer> head) {
		final ListNode<Integer> dummyHead = new ListNode<>(-1, head);
		final Set<Integer> s = new HashSet<>();
		for (int num : nums)
			s.add(num);

		ListNode<Integer> prev = dummyHead;
		while (prev.next != null) {
			if (s.contains(prev.next.val))
				prev.next = prev.next.next;
			else
				prev = prev.next;
		}

		return dummyHead.next;
	}
}
