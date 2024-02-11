package com.coding.challenge;

/**
 * Definition for singly-linked list.
 */
public final class ListNode<T> {
	public T val;
	public ListNode<T> next;

	public ListNode(T val) {
		this.val = val;
	}

	public ListNode(T val, ListNode<T> next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		if (next == null)
			return val + "";

		return val + next.toString();
	}
}
