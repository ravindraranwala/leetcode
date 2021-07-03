package com.coding.challenge;

/**
 * Definition for singly-linked list.
 */
public final class ListNode {
	public final int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
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
