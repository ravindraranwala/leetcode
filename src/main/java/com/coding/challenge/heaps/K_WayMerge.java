package com.coding.challenge.heaps;

import java.util.Comparator;

import com.coding.challenge.ListNode;

public class K_WayMerge {
	private K_WayMerge() {
		throw new AssertionError("Non instantiable !");
	}

	public static void main(String[] args) {
		// Testcase one
		final ListNode<Integer> listOneHead = new ListNode<>(1);
		final ListNode<Integer> listOneNode2 = new ListNode<>(4);
		listOneHead.next = listOneNode2;
		final ListNode<Integer> listOneNode3 = new ListNode<>(5);
		listOneNode2.next = listOneNode3;

		final ListNode<Integer> listTwoHead = new ListNode<>(1);
		final ListNode<Integer> listTwoNode2 = new ListNode<>(3);
		listTwoHead.next = listTwoNode2;
		final ListNode<Integer> listTwoNode3 = new ListNode<>(4);
		listTwoNode2.next = listTwoNode3;

		final ListNode<Integer> listThreeHead = new ListNode<>(2);
		final ListNode<Integer> listThreeNode2 = new ListNode<>(6);
		listThreeHead.next = listThreeNode2;

		final ListNode<Integer> mergedList = kWayMerge(listOneHead, listTwoHead, listThreeHead);
		System.out.println(mergedList);

		// Testcase two
		final ListNode<Integer> mergedList2 = kWayMerge();
		System.out.println(mergedList2);

		// Testcase three
		final ListNode[] emptyNodes = new ListNode[] { null };
		final ListNode<Integer> mergedList3 = kWayMerge(emptyNodes);
		System.out.println(mergedList3);
	}

	public static <T> ListNode<T> kWayMerge(Comparator<? super T> cmp, ListNode<T>... sortedLists) {
		final Comparator<ListNode<T>> listNodeCmp = (o1, o2) -> cmp.compare(o1.val, o2.val);
		final Queue<ListNode<T>> queue = PriorityQueue.of(listNodeCmp, sortedLists.length);
		for (ListNode<T> n : sortedLists)
			// Adding the first element of each list to the heap.
			if (n != null)
				queue.insert(n);

		final ListNode<T> dummyHead = new ListNode<>(null);
		for (ListNode<T> current = dummyHead; !queue.isEmpty(); current = current.next) {
			final ListNode<T> node = queue.extract();
			// current.next = new ListNode<T>(node.val);
			current.next = node;
			final ListNode<T> nextNode = node.next;
			if (nextNode != null)
				queue.insert(nextNode);
		}
		return dummyHead.next;
	}

	public static <T extends Comparable<? super T>> ListNode<T> kWayMerge(ListNode<T>... sortedLists) {
		return kWayMerge(Comparator.naturalOrder(), sortedLists);
	}
}