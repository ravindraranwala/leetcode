package com.coding.challenge.linked.list;

import java.util.Comparator;

import com.coding.challenge.ListNode;

class MergeTwoSortedLists {

	MergeTwoSortedLists() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1
		final ListNode<Integer> one = new ListNode<>(1);
		final ListNode<Integer> two = new ListNode<>(2);
		final ListNode<Integer> four = new ListNode<>(4);
		one.next = two;
		two.next = four;

		final ListNode<Integer> one2 = new ListNode<>(1);
		final ListNode<Integer> three = new ListNode<>(3);
		final ListNode<Integer> four2 = new ListNode<>(4);
		one2.next = three;
		three.next = four2;
		ListNode<Integer> res = mergeTwoLists(one, one2);
		System.out.println(res);

		// Usecase 2
		res = mergeTwoLists(null, null);
		System.out.println(res);

		// Usecase 3
		final ListNode<Integer> zero = new ListNode<>(0);
		res = mergeTwoLists(null, zero);
		System.out.println(res);
	}

	static <T extends Comparable<? super T>> ListNode<T> mergeTwoLists(ListNode<T> l1, ListNode<T> l2) {
		return mergeTwoLists(l1, l2, Comparator.naturalOrder());
	}

	static <T> ListNode<T> mergeTwoLists(ListNode<T> l1, ListNode<T> l2, Comparator<? super T> cmp) {
		final ListNode<T> dummyHead = new ListNode<>(null);
		ListNode<T> current = dummyHead;
		while (l1 != null && l2 != null) {
			if (cmp.compare(l1.val, l2.val) <= 0) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null)
			current.next = l1;
		else
			current.next = l2;
		return dummyHead.next;
	}
}
