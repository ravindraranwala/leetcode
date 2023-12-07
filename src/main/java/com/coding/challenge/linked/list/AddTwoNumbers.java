package com.coding.challenge.linked.list;

import java.util.ArrayDeque;
import java.util.Deque;

import com.coding.challenge.ListNode;

class AddTwoNumbers {
	AddTwoNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> l1 = new ListNode<Integer>(7, new ListNode<>(2, new ListNode<>(4, new ListNode<>(3))));
		final ListNode<Integer> l2 = new ListNode<>(5, new ListNode<>(6, new ListNode<>(4)));
		assert "7807".equals(addTwoNumbers(l1, l2).toString());

		assert "10".equals(addTwoNumbers(new ListNode<>(5), new ListNode<>(5)).toString());

		final ListNode<Integer> l3 = new ListNode<Integer>(9, new ListNode<>(1));
		assert "100".equals(addTwoNumbers(l3, new ListNode<Integer>(9)).toString());
	}

	static ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
		final Deque<Integer> s1 = new ArrayDeque<>();
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}

		final Deque<Integer> s2 = new ArrayDeque<>();
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		ListNode<Integer> tail = null;
		int cf = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			int s = 0;
			if (!s1.isEmpty())
				s = s + s1.pop();
			if (!s2.isEmpty())
				s = s + s2.pop();
			final int val = s + cf >= 10 ? s + cf - 10 : s + cf;
			cf = (s + cf) / 10;
			tail = new ListNode<>(val, tail);
		}

		return cf > 0 ? new ListNode<>(cf, tail) : tail;
	}
}
