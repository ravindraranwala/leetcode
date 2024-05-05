package com.coding.challenge.linked.list;

import com.coding.challenge.ListNode;

class DeleteNodeInLinkedList {
	DeleteNodeInLinkedList() {
		throw new AssertionError();
	}

	public static void main(String[] args) {

	}

	static void deleteNode(ListNode<Integer> node) {
		ListNode<Integer> curr = node;
		while (curr.next.next != null) {
			curr.val = curr.next.val;
			curr = curr.next;
		}
		curr.val = curr.next.val;
		curr.next = null;
	}
}
