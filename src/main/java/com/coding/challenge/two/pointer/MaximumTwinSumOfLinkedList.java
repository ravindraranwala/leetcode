package com.coding.challenge.two.pointer;

import com.coding.challenge.ListNode;

class MaximumTwinSumOfLinkedList {
	MaximumTwinSumOfLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> listOne = new ListNode<>(5, new ListNode<>(4, new ListNode<>(2, new ListNode<>(1))));
		assert pairSum(listOne) == 6;

		final ListNode<Integer> listTwo = new ListNode<>(4, new ListNode<>(2, new ListNode<>(25, new ListNode<>(3))));
		assert pairSum(listTwo) == 27;

		final ListNode<Integer> listThree = new ListNode<>(1, new ListNode<>(100000));
		assert pairSum(listThree) == 100001;
	}

	static int pairSum(ListNode<Integer> head) {
		ListNode<Integer> slow = head;
		ListNode<Integer> fast = head;

		while (fast != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode<Integer> prev = slow;
		ListNode<Integer> curr = slow.next;
		while (curr != null) {
			final ListNode<Integer> tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}

		ListNode<Integer> tail = prev;
		ListNode<Integer> s = head;
		int pairSum = Integer.MIN_VALUE;
		while (s != slow) {
			pairSum = Math.max(pairSum, s.val + tail.val);
			s = s.next;
			tail = tail.next;
		}

		return pairSum;
	}
}
