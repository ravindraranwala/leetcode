package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

import com.coding.challenge.ListNode;

class RemoveNodesFromLinkedList {
	RemoveNodesFromLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> l1 = new ListNode<>(5,
				new ListNode<>(2, new ListNode<>(13, new ListNode<>(3, new ListNode<>(8)))));
		System.out.println(removeNodes(l1));

		final ListNode<Integer> l2 = new ListNode<>(1, new ListNode<>(1, new ListNode<>(1, new ListNode<>(1))));
		System.out.println(removeNodes(l2));
	}

	static ListNode<Integer> removeNodes(ListNode<Integer> head) {
		final Deque<ListNode<Integer>> s = new ArrayDeque<>();
		s.push(new ListNode<>(100001));

		for (ListNode<Integer> curr = head; curr != null; curr = curr.next) {
			while (s.peek().val < curr.val)
				s.pop();

			s.peek().next = curr;
			s.push(curr);
		}

		return s.pollLast().next;
	}
}
