package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class ConvertBinaryNumberInLinkedListToInteger {
	ConvertBinaryNumberInLinkedListToInteger() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final ListNode<Integer> l1 = new ListNode<>(1, new ListNode<>(0, new ListNode<>(1)));
		assert getDecimalValue(l1) == 5;

		assert getDecimalValue(new ListNode<Integer>(0)) == 0;
	}

	static int getDecimalValue(ListNode<Integer> head) {
		ListNode<Integer> prev = null;
		ListNode<Integer> curr = head;
		while (curr != null) {
			final ListNode<Integer> next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		int val = 0;
		int decRep = 1;
		for (ListNode<Integer> currNode = prev; currNode != null; currNode = currNode.next) {
			val = val + decRep * currNode.val;
			decRep = decRep * 2;
		}

		return val;
	}
}
